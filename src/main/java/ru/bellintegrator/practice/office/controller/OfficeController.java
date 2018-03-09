package ru.bellintegrator.practice.office.controller;

import ru.bellintegrator.practice.office.model.Office;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OfficeController {

    List<Office> list(Office office);

    String findOfficeById(Long id);

    String update(Office office);

    String delete(Office office);

    String save(Office office);
}
