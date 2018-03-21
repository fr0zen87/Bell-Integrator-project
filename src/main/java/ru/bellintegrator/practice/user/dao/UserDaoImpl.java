package ru.bellintegrator.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.documents.model.DocType;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.views.requests.UserSaveRequest;
import ru.bellintegrator.practice.user.views.requests.UserUpdateRequest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
        // TODO: 21.03.2018 add realization
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
