package ru.bellintegrator.practice.organization.controller;

import org.springframework.http.ResponseEntity;
import ru.bellintegrator.practice.organization.views.requests.OrganizationDeleteRequest;
import ru.bellintegrator.practice.organization.views.requests.OrganizationFilter;
import ru.bellintegrator.practice.organization.views.requests.OrganizationSaveRequest;
import ru.bellintegrator.practice.organization.views.requests.OrganizationUpdateRequest;

/**
 * Organization controller
 */
public interface OrganizationController {

    /**
     * Find organizations by filter
     */
    ResponseEntity<Object> list(OrganizationFilter filter);

    /**
     * Find organization by id
     */
    ResponseEntity<Object> loadById(Long id);

    /**
     * Update organization
     */
    ResponseEntity<Object> update(OrganizationUpdateRequest update);

    /**
     * Save organization
     */
    ResponseEntity<Object> save(OrganizationSaveRequest save);

    /**
     * Delete organization
     */
    ResponseEntity<Object> delete(OrganizationDeleteRequest delete);
}
