package ru.bellintegrator.practice.office.controller;

import org.springframework.http.ResponseEntity;
import ru.bellintegrator.practice.office.views.requests.OfficeDeleteRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeFilter;
import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeUpdateRequest;

/**
 * Office controller
 */
public interface OfficeController {

    /**
     * Find offices by filter
     */
    ResponseEntity<Object> list(OfficeFilter filter);

    /**
     * Find office by id
     */
    ResponseEntity<Object> findOfficeById(Long id) throws Exception;

    /**
     * Update office
     */
    ResponseEntity<Object> update(OfficeUpdateRequest update);

    /**
     * Delete office
     */
    ResponseEntity<Object> delete(OfficeDeleteRequest delete);

    /**
     * Save office
     */
    ResponseEntity<Object> save(OfficeSaveRequest save);
}
