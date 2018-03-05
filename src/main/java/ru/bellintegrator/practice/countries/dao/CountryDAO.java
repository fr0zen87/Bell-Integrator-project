package ru.bellintegrator.practice.countries.dao;

import ru.bellintegrator.practice.countries.model.Countries;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface CountryDAO {

    List<Countries> countries();
}
