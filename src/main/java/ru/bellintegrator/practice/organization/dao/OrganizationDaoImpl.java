package ru.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> list(String name, String inn, boolean isActive) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);

        Root<Organization> organization = criteriaQuery.from(Organization.class);

        if (inn != null) {
            criteriaQuery.where(builder.equal(organization.get("name"), name),
                    builder.equal(organization.get("inn"), inn),
                    builder.equal(organization.get("isActive"), true));
        } else {
            criteriaQuery.where(builder.equal(organization.get("name"), name),
                    builder.equal(organization.get("isActive"), true));
        }

        TypedQuery<Organization> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public Organization loadById(Long id) {
        Organization organization = em.find(Organization.class, id);
        if (organization == null || !organization.isActive()) {
            throw new NullPointerException(
                    String.format("Active organization with id=%s not found", id));
        }
        return organization;
    }

    @Override
    public Organization update(Organization organization) {
        Organization org = em.find(Organization.class, organization.getId());
        if (org == null) {
            throw new NullPointerException(
                    String.format("Organization with id=%s not found", organization.getId()));
        }
        org.setName(organization.getName());
        org.setFullName(organization.getFullName());
        org.setInn(organization.getInn());
        org.setKpp(organization.getKpp());
        org.setAddress(organization.getAddress());
        org.setPhone(organization.getPhone());
        org.setActive(true);
        return em.merge(org);
    }

    @Override
    public void save(Organization organization) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);

        Root<Organization> org = criteriaQuery.from(Organization.class);
        criteriaQuery.where(builder.equal(org.get("fullName"), organization.getFullName()),
                builder.equal(org.get("isActive"), true));

        TypedQuery<Organization> query = em.createQuery(criteriaQuery);
        List<Organization> resultList = query.getResultList();
        if (resultList.size() != 0) {
            throw new EntityExistsException("Organization already exists");
        }
        em.persist(organization);
    }

    @Override
    public void delete(Long id) {
        Organization organization = em.find(Organization.class, id);
        if (organization == null) {
            throw new NullPointerException(
                    String.format("Organization with id=%s not found", id));
        }
        organization.getOffices().forEach(office -> {
            office.setOrganization(null);
        });
        organization.setOffices(null);
        em.remove(organization);
    }
}
