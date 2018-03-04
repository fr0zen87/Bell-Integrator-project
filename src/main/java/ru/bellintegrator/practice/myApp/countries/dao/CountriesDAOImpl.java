package ru.bellintegrator.practice.myApp.countries.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.myApp.countries.model.Countries;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CountriesDAOImpl implements CountriesDAO {

    private final EntityManager em;

    @Autowired
    public CountriesDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Countries> countries() {
        TypedQuery<Countries> query = em.createQuery("SELECT c FROM Countries c",
                Countries.class);
        return query.getResultList();
    }
}
