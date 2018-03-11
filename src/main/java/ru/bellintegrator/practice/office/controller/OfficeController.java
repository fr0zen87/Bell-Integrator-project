package ru.bellintegrator.practice.office.controller;

import ru.bellintegrator.practice.office.model.Office;

import java.util.Map;

/**
 * {@inheritDoc}
 */
public interface OfficeController {

    Map list(Office office);

    Map findOfficeById(Long id);

    Map update(Office office);

    Map delete(Office office);

    Map save(Office office);
}
