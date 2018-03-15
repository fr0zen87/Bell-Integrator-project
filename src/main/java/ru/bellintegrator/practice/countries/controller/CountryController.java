package ru.bellintegrator.practice.countries.controller;

import ru.bellintegrator.practice.countries.views.CountryView;

import java.util.List;
import java.util.Map;

/**
 * Country controller
 */
public interface CountryController {

    /**
     * @return map of all countries
     */
    Map<String, List<CountryView>> countries();
}
