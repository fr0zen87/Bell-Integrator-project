package ru.bellintegrator.practice.myApp.countries.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.myApp.countries.dao.CountriesDAO;
import ru.bellintegrator.practice.myApp.docs.service.DocsServiceImpl;
import ru.bellintegrator.practice.myApp.countries.model.Countries;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountriesServiceImpl implements CountriesService {

    private final Logger log = LoggerFactory.getLogger(DocsServiceImpl.class);

    private final CountriesDAO dao;

    @Autowired
    public CountriesServiceImpl(CountriesDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Countries> countries() {
        List<Countries> all = dao.countries();

        return all.stream()
                .map(c -> {
                    Countries countries = new Countries();
                    countries.setName(c.getName());
                    countries.setCode(c.getCode());

                    log.info(countries.toString());

                    return countries;
                })
                .collect(Collectors.toList());
    }
}
