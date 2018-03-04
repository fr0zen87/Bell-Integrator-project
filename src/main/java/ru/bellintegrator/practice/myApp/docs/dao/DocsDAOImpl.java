package ru.bellintegrator.practice.myApp.docs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.myApp.docs.dao.DocsDAO;
import ru.bellintegrator.practice.myApp.docs.model.Docs;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocsDAOImpl implements DocsDAO {

    private final EntityManager em;

    @Autowired
    public DocsDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Docs> docs() {
        TypedQuery<Docs> query = em.createQuery("SELECT d FROM Docs d",
                Docs.class);
        return query.getResultList();
    }
}
