package ru.bellintegrator.practice.countries.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.countries.dao.CountryDao;
import ru.bellintegrator.practice.documents.service.DocTypeServiceImpl;
import ru.bellintegrator.practice.countries.model.Country;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final Logger log = LoggerFactory.getLogger(DocTypeServiceImpl.class);

    private final CountryDao dao;

    @Autowired
    public CountryServiceImpl(CountryDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Country> countries() {
        List<Country> all = dao.countries();
        log.debug(all.toString());
        return dao.countries();
    }
}
