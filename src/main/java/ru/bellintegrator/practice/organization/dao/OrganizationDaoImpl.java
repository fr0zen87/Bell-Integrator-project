package ru.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.views.OrganizationView;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> list(OrganizationView view) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);

        Root<Organization> organization = criteriaQuery.from(Organization.class);

        if (view.getInn() != null && view.getActive() != null) {
            criteriaQuery.where(builder.equal(organization.get("name"), view.getName()),
                    builder.equal(organization.get("inn"), view.getInn()),
                    builder.equal(organization.get("isActive"), view.getActive()));
        } else if (view.getInn() != null) {
            criteriaQuery.where(builder.equal(organization.get("name"), view.getName()),
                    builder.equal(organization.get("inn"), view.getInn()));
        } else if (view.getActive() != null) {
            criteriaQuery.where(builder.equal(organization.get("name"), view.getName()),
                    builder.equal(organization.get("isActive"), view.getActive()));
        } else {
            criteriaQuery.where(builder.equal(organization.get("name"), view.getName()));
        }

        TypedQuery<Organization> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public Organization loadById(Long id) {
        Organization organization = em.find(Organization.class, id);
        if (organization == null) {
            throw new NullPointerException(
                    String.format("Organization with id=%s not found", id));
        }
        return organization;
    }

    @Override
    public void update(OrganizationView view) {
        Organization org = em.find(Organization.class, view.getId());
        if (org == null) {
            throw new NullPointerException(
                    String.format("Organization with id=%s not found", view.getId()));
        }
        org.setName(view.getName());
        org.setFullName(view.getFullName());
        org.setInn(view.getInn());
        org.setKpp(view.getKpp());
        org.setAddress(view.getAddress());
        org.setPhone(view.getPhone());
        org.setActive(true);
        em.merge(org);
    }

    @Override
    public void save(OrganizationView view) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);

        Root<Organization> org = criteriaQuery.from(Organization.class);
        criteriaQuery.where(builder.equal(org.get("fullName"), view.getFullName()));

        TypedQuery<Organization> query = em.createQuery(criteriaQuery);
        List<Organization> resultList = query.getResultList();
        if (resultList.size() != 0) {
            throw new EntityExistsException("Organization already exists");
        }
        Organization organizationToPersist = new Organization(view);
        em.persist(organizationToPersist);
    }

    @Override
    public void delete(Long id) {
        Organization organization = em.find(Organization.class, id);
        if (organization == null) {
            throw new NullPointerException(
                    String.format("Organization with id=%s not found", id));
        }
        if (organization.getOffices() != null) {
            organization.getOffices().forEach(office -> office.setOrganization(null));
            organization.setOffices(null);
        }
        em.remove(organization);
    }
}
