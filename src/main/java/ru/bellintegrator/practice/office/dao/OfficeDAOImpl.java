package ru.bellintegrator.practice.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OfficeDAOImpl implements OfficeDAO {

    private final EntityManager em;

    @Autowired
    public OfficeDAOImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List<Office> list(Office o) {
        // TODO: 09.03.2018 add filter
        return null;
    }

    @Override
    public Office findOfficeById(Long id) {
        Office office = em.find(Office.class, id);
        if (office == null || !office.isActive()) {
            throw new NullPointerException(
                    String.format("Active office with id=%s not found", id));
        }
        return office;
    }

    @Override
    public Office update(Office o) {
        Office office = em.find(Office.class, o.getId());
        if (office == null) {
            throw new NullPointerException(
                    String.format("Office with id=%s not found", o.getId()));
        }
        office.setName(o.getName());
        office.setAddress(o.getAddress());
        office.setPhone(o.getPhone());
        office.setActive(true);
        if (o.getOrganization() != null) {
            office.getOrganization().addOffice(o);
        }
        return em.merge(office);
    }

    @Override
    public void delete(Long id) {
        Office office = em.find(Office.class, id);
        if (office == null) {
            throw new NullPointerException(
                    String.format("Office with id=%s not found", id));
        }
        if (office.getOrganization() != null) {
            office.getOrganization().removeOffice(office);
        }
        em.remove(office);
    }

    @Override
    public void save(Office o) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = builder.createQuery(Office.class);

        Root<Office> office = criteriaQuery.from(Office.class);
        criteriaQuery.where(builder.equal(office.get("name"), o.getName()),
                builder.equal(office.get("isActive"), true));

        TypedQuery<Office> query = em.createQuery(criteriaQuery);
        if (query.getResultList().size() != 0) {
            throw new EntityExistsException("Office already exists");
        }
        if (o.getOrganization() != null) {
            o.getOrganization().addOffice(o);
        }
        em.persist(o);
    }
}
