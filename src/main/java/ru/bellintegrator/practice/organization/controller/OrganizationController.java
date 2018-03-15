package ru.bellintegrator.practice.organization.controller;

import org.springframework.http.ResponseEntity;
import ru.bellintegrator.practice.organization.views.RequestView;

/**
 * {@inheritDoc}
 */
public interface OrganizationController {

    ResponseEntity<Object> list(RequestView view);

    ResponseEntity<Object> loadById(Long id);

    ResponseEntity<Object> update(RequestView view);

    ResponseEntity<Object> save(RequestView view);

    ResponseEntity<Object> delete(RequestView view);
}
