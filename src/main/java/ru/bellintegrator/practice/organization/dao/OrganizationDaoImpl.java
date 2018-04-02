package ru.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.views.requests.OrganizationFilter;
import ru.bellintegrator.practice.organization.views.requests.OrganizationSaveRequest;
import ru.bellintegrator.practice.organization.views.requests.OrganizationUpdateRequest;

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
    public List<Organization> list(OrganizationFilter filter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);

        Root<Organization> organization = criteriaQuery.from(Organization.class);

        if (filter.getInn() != null && filter.getActive() != null) {
            criteriaQuery.where(builder.equal(organization.get("name"), filter.getName()),
                    builder.equal(organization.get("inn"), filter.getInn()),
                    builder.equal(organization.get("isActive"), filter.getActive()));
        } else if (filter.getInn() != null) {
            criteriaQuery.where(builder.equal(organization.get("name"), filter.getName()),
                    builder.equal(organization.get("inn"), filter.getInn()));
        } else if (filter.getActive() != null) {
            criteriaQuery.where(builder.equal(organization.get("name"), filter.getName()),
                    builder.equal(organization.get("isActive"), filter.getActive()));
        } else {
            criteriaQuery.where(builder.equal(organization.get("name"), filter.getName()));
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
    public void update(OrganizationUpdateRequest update) {
        Organization organization = em.find(Organization.class, update.getId());
        if (organization == null) {
            throw new NullPointerException(
                    String.format("Organization with id=%s not found", update.getId()));
        }
        organization.update(update);
        em.merge(organization);
    }

    @Override
    public void save(OrganizationSaveRequest save) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);

        Root<Organization> organization = criteriaQuery.from(Organization.class);
        criteriaQuery.where(builder.equal(organization.get("fullName"), save.getFullName()));

        TypedQuery<Organization> query = em.createQuery(criteriaQuery);
        List<Organization> resultList = query.getResultList();
        if (resultList.size() != 0) {
            throw new EntityExistsException("Organization already exists");
        }
        Organization organizationToPersist = new Organization(save);
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
