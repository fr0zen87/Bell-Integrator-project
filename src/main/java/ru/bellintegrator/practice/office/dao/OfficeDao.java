package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OfficeDao {

    List<Office> list(Office office);

    Office findOfficeById(Long id);

    Office update(Office office);

    void delete(Long id);

    void save(Office office);
}
