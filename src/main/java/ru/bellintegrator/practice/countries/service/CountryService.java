package ru.bellintegrator.practice.countries.service;

import ru.bellintegrator.practice.countries.views.CountryView;

import java.util.List;
import java.util.Map;

/**
 * Service to work with Country
 */
public interface CountryService {

    /**
     * @return map of all Countries
     */
    Map<String, List<CountryView>> countries();
}
