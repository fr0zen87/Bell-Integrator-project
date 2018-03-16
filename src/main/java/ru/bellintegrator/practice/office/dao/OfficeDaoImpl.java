package ru.bellintegrator.practice.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.views.requests.OfficeFilter;
import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeUpdateRequest;
import ru.bellintegrator.practice.organization.model.Organization;

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
    public List<Office> list(OfficeFilter filter) {
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
    public void update(OfficeUpdateRequest update) {
        Office office = em.find(Office.class, update.getId());
        if (office == null) {
            throw new NullPointerException(
                    String.format("Office with id=%s not found", update.getId()));
        }
        office.setName(update.getName());
        office.setAddress(update.getAddress());
        office.setPhone(update.getPhone());
        office.setActive(update.getActive());
        em.merge(office);
    }

    @Override
    public void delete(Long id) {
        Office office = em.find(Office.class, id);
        if (office == null) {
            throw new NullPointerException(
                    String.format("Office with id=%s not found", id));
        }
        office.getOrganization().removeOffice(office);
        em.remove(office);
    }

    @Override
    public void save(OfficeSaveRequest save) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = builder.createQuery(Office.class);

        Root<Office> office = criteriaQuery.from(Office.class);
        criteriaQuery.where(builder.equal(office.get("name"), save.getName()));

        TypedQuery<Office> query = em.createQuery(criteriaQuery);
        if (query.getResultList().size() != 0) {
            throw new EntityExistsException("Office already exists");
        }
        Office officeToPersist = new Office(save);
        Long id = save.getOrgId();
        if (id != null) {
            Organization organization = em.find(Organization.class, id);
            if (organization == null) {
                throw new NullPointerException(
                        String.format("Organization with id=%s not found", id));
            }
            organization.addOffice(officeToPersist);
        }
        em.persist(officeToPersist);
    }
}
