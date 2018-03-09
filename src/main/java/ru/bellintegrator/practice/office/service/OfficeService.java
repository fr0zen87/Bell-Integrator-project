package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.model.Office;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OfficeService {

    List<Office> list(Office office);

    Office findOfficeById(Long id);

    Office update(Office office);

    void delete(Long id);

    void save(Office office);
}
