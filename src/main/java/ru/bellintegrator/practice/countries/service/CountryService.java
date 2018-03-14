package ru.bellintegrator.practice.countries.service;

import ru.bellintegrator.practice.countries.views.CountryView;

import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}
 */
public interface CountryService {
    Map<String, List<CountryView>> countries();
}
