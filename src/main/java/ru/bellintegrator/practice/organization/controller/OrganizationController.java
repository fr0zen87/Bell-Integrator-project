package ru.bellintegrator.practice.organization.controller;

import ru.bellintegrator.practice.organization.model.Organization;

import java.util.Map;

/**
 * {@inheritDoc}
 */
public interface OrganizationController {

    Map list(Organization organization);

    Map loadById(Long id);

    Map update(Organization organization);

    Map save(Organization organization);

    Map delete(Organization organization);
}
