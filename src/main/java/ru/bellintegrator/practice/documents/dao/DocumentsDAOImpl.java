package ru.bellintegrator.practice.documents.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.documents.model.Documents;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocumentsDAOImpl implements DocumentsDAO {

    private final EntityManager em;

    @Autowired
    public DocumentsDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Documents> docs() {
        TypedQuery<Documents> query = em.createQuery("SELECT d FROM Documents d",
                Documents.class);
        return query.getResultList();
    }
}
