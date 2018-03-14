package ru.bellintegrator.practice.countries.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.countries.views.CountryView;
import ru.bellintegrator.practice.countries.dao.CountryDao;
import ru.bellintegrator.practice.documents.service.DocTypeServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, List<CountryView>> countries() {

        Map<String, List<CountryView>> result = new HashMap<>();
        List<CountryView> countryViews = new ArrayList<>();
        dao.findAll().forEach(country -> {
            CountryView countryView = new CountryView();
            countryView.setName(country.getName());
            countryView.setCode(country.getCode());
            log.debug(countryView.toString());
            countryViews.add(countryView);
        });
        result.put("data", countryViews);
        return result;
    }
}
