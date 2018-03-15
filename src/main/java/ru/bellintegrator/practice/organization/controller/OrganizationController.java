package ru.bellintegrator.practice.organization.controller;

import org.springframework.http.ResponseEntity;
import ru.bellintegrator.practice.organization.views.OrganizationView;

/**
 * {@inheritDoc}
 */
public interface OrganizationController {

    ResponseEntity<Object> list(OrganizationView view);

    ResponseEntity<Object> loadById(Long id);

    ResponseEntity<Object> update(OrganizationView view);

    ResponseEntity<Object> save(OrganizationView view);

    ResponseEntity<Object> delete(OrganizationView view);
}
