package ru.bellintegrator.practice.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.views.OfficeView;

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
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List<Office> list(OfficeView view) {
        // TODO: 09.03.2018 add filter
        return null;
    }

    @Override
    public Office findOfficeById(Long id) {
        Office office = em.find(Office.class, id);
        if (office == null) {
            throw new NullPointerException(
                    String.format("Office with id=%s not found", id));
        }
        return office;
    }

    @Override
    public void update(OfficeView view) {
        Office office = em.find(Office.class, view.getId());
        if (office == null) {
            throw new NullPointerException(
                    String.format("Office with id=%s not found", view.getId()));
        }
        office.setName(view.getName());
        office.setAddress(view.getAddress());
        office.setPhone(view.getPhone());
        office.setActive(true);
        em.merge(office);
    }

    @Override
    public void delete(Long id) {
        Office office = em.find(Office.class, id);
        if (office == null) {
            throw new NullPointerException(
                    String.format("Office with id=%s not found", id));
        }
        em.remove(office);
    }

    @Override
    public void save(OfficeView view) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = builder.createQuery(Office.class);

        Root<Office> office = criteriaQuery.from(Office.class);
        criteriaQuery.where(builder.equal(office.get("name"), view.getName()),
                builder.equal(office.get("isActive"), true));

        TypedQuery<Office> query = em.createQuery(criteriaQuery);
        if (query.getResultList().size() != 0) {
            throw new EntityExistsException("Office already exists");
        }
        Office officeToPersist = new Office(view);
        em.persist(officeToPersist);
    }
}
