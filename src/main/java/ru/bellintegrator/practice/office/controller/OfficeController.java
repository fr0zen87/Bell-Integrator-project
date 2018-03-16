package ru.bellintegrator.practice.office.controller;

import org.springframework.http.ResponseEntity;
import ru.bellintegrator.practice.office.views.OfficeView;

/**
 * Office controller
 */
public interface OfficeController {

    /**
     * Find offices by filter
     */
    ResponseEntity<Object> list(OfficeView view);

    /**
     * Find office by id
     */
    ResponseEntity<Object> findOfficeById(Long id);

    /**
     * Update office
     */
    ResponseEntity<Object> update(OfficeView view);

    /**
     * Delete office
     */
    ResponseEntity<Object> delete(OfficeView view);

    /**
     * Save office
     */
    ResponseEntity<Object> save(OfficeView view);
}
