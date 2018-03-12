package ru.bellintegrator.practice.countries.dao;

import ru.bellintegrator.practice.countries.model.Country;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface CountryDao {

    List<Country> countries();
}
