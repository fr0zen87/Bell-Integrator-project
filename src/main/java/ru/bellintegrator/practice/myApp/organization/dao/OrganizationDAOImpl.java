package ru.bellintegrator.practice.myApp.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.myApp.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    private final EntityManager em;

    @Autowired
    public OrganizationDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> list(String name, String inn, boolean isActive) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);

        Root<Organization> organization = criteriaQuery.from(Organization.class);
        criteriaQuery.where(builder.equal(organization.get("name"), name),
                builder.equal(organization.get("inn"), inn),
                builder.equal(organization.get("isActive"), isActive));

        TypedQuery<Organization> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public Organization loadById(Long id) {
        Organization organization = em.find(Organization.class, id);
        if (organization != null) {
            return organization;
        }
        return null;
    }

    @Override
    public String update(Organization organization) {
        Organization org = em.find(Organization.class, organization.getId());
        if (org != null) {
            org.setName(organization.getName());
            org.setFullName(organization.getFullName());
            org.setInn(organization.getInn());
            org.setKpp(organization.getKpp());
            org.setAddress(organization.getAddress());
            org.setPhone(organization.getPhone());
            org.setActive(organization.isActive());
            em.merge(org);
            return "Success";
        }
        return "Error";
    }

    @Override
    public String save(Organization organization) {
        em.persist(organization);
        return "Success";
    }

    @Override
    public String delete(Long id) {
        Organization organization = em.find(Organization.class, id);
        if (organization != null) {
            em.remove(loadById(id));
            return "Success";
        }
        return "Error";
    }
}
