package ru.bellintegrator.practice.countries.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.countries.dao.CountryDAO;
import ru.bellintegrator.practice.documents.service.DocumentsServiceImpl;
import ru.bellintegrator.practice.countries.model.Countries;

import java.util.List;

@Service
public class CountriesServiceImpl implements CountriesService {

    private final Logger log = LoggerFactory.getLogger(DocumentsServiceImpl.class);

    private final CountryDAO dao;

    @Autowired
    public CountriesServiceImpl(CountryDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Countries> countries() {
        List<Countries> all = dao.countries();
        log.debug(all.toString());
        return dao.countries();
    }
}
