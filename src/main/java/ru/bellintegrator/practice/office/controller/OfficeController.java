package ru.bellintegrator.practice.office.controller;

import org.springframework.http.ResponseEntity;
import ru.bellintegrator.practice.office.views.OfficeView;

/**
 * {@inheritDoc}
 */
public interface OfficeController {

    ResponseEntity<Object> list(OfficeView view);

    ResponseEntity<Object> findOfficeById(Long id);

    ResponseEntity<Object> update(OfficeView view);

    ResponseEntity<Object> delete(OfficeView view);

    ResponseEntity<Object> save(OfficeView view);
}
