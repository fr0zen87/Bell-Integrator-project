package ru.bellintegrator.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.documents.model.DocType;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.views.requests.UserSaveRequest;
import ru.bellintegrator.practice.user.views.requests.UserUpdateRequest;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> list(Map<String, Object> filters) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT u FROM User u WHERE");
        filters.forEach((key, value) ->
                sb.append(String.format(" u.%s = '%s' AND", key, value)));

        TypedQuery<User> query =
                em.createQuery(sb.substring(0, sb.length() - 4), User.class);

        return query.getResultList();
    }

    @Override
    public User loadById(Long id) {
        User user = em.find(User.class, id);
        if (user == null) {
            throw new NullPointerException(
                    String.format("User with id=%s not found", id));
        }
        return user;
    }

    @Override
    public void update(UserUpdateRequest update) {
        User user = em.find(User.class, update.getId());
        if (user == null) {
            throw new NullPointerException(
                    String.format("User with id=%s not found", update.getId()));
        }
        if (user.getDocumentNumber().equals(update.getDocNumber())) {
            throw new EntityExistsException("User with such docNumber already exists");
        }

        DocType docType = findDocType(update.getDocName(), update.getDocCode());
        Country country = findCountry(update.getCitizenshipName(), update.getCitizenshipCode());

        user.setFirstName(update.getFirstName());
        user.setSecondName(update.getSecondName());
        user.setMiddleName(update.getMiddleName());
        user.setPosition(update.getPosition());
        user.setPhone(update.getPhone());
        user.setDocType(docType);
        user.setDocumentNumber(update.getDocNumber());
        user.setDocumentDate(update.getDocDate());
        user.setCountry(country);
        user.setIdentified(update.getIdentified());
        em.merge(user);
    }

    @Override
    public void delete(Long id) {
        User user = em.find(User.class, id);
        if (user == null) {
            throw new NullPointerException(
                    String.format("User with id=%s not found", id));
        }
        user.getOffice().removeUser(user);
        em.remove(user);
    }

    @Override
    public void save(UserSaveRequest save) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.where(builder.equal(user.get("documentNumber"), save.getDocNumber()));

        TypedQuery<User> query = em.createQuery(criteriaQuery);
        if (query.getResultList().size() != 0) {
            throw new EntityExistsException("User with such docNumber already exists");
        }

        Long officeId = save.getOfficeId();
        Office office = em.find(Office.class, officeId);
        if (office == null) {
            throw new NullPointerException(
                    String.format("Office with id=%s not found", officeId));
        }

        DocType docType = findDocType(save.getDocName(), save.getDocCode());
        Country country = findCountry(save.getCitizenshipName(), save.getCitizenshipCode());

        User userToPersist = new User(save, docType, country);
        office.addUser(userToPersist);

        em.persist(userToPersist);
    }

    private DocType findDocType(String name, String code) {
        TypedQuery<DocType> query =
                em.createQuery("SELECT d FROM DocType d WHERE name = '" +
                        name + "' AND code = '" + code + "'", DocType.class);
        List<DocType> list = query.getResultList();
        if (list.size() == 0) {
            throw new NullPointerException(
                    "Incorrect docName or docCode parameters");
        }
        return list.get(0);
    }

    private Country findCountry(String name, String code) {
        TypedQuery<Country> query =
                em.createQuery("SELECT c FROM Country c WHERE name = '" +
                        name + "' AND code = '" + code + "'", Country.class);
        List<Country> list = query.getResultList();
        if (list.size() == 0) {
            throw new NullPointerException(
                    "Incorrect citizenshipName or citizenshipCode parameters");
        }
        return list.get(0);
    }
}
