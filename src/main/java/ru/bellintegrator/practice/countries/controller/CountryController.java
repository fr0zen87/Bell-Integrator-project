package ru.bellintegrator.practice.countries.controller;

import ru.bellintegrator.practice.countries.views.CountryView;

import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}
 */
public interface CountryController {

    Map<String, List<CountryView>> countries();
}
