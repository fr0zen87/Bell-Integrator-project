package ru.bellintegrator.practice.organization.controller;

import org.springframework.http.ResponseEntity;
import ru.bellintegrator.practice.organization.views.OrganizationView;

/**
 * Organization controller
 */
public interface OrganizationController {

    /**
     * Find organizations by filter
     */
    ResponseEntity<Object> list(OrganizationView view);

    /**
     * Find organization by id
     */
    ResponseEntity<Object> loadById(Long id);

    /**
     * Update organization
     */
    ResponseEntity<Object> update(OrganizationView view);

    /**
     * Save organization
     */
    ResponseEntity<Object> save(OrganizationView view);

    /**
     * Delete organization
     */
    ResponseEntity<Object> delete(OrganizationView view);
}
