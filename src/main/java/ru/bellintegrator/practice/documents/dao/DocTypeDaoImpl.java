package ru.bellintegrator.practice.documents.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.documents.model.DocType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocTypeDaoImpl implements DocTypeDao {

    private final EntityManager em;

    @Autowired
    public DocTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DocType> docs() {
        TypedQuery<DocType> query = em.createQuery("SELECT d FROM DocType d",
                DocType.class);
        return query.getResultList();
    }
}
