package ru.bellintegrator.practice.countries.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.countries.model.Country;

/**
 * Dao to work with Country
 */
public interface CountryDao extends JpaRepository<Country, Long> {
}
