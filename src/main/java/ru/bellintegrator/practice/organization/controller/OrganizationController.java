package ru.bellintegrator.practice.organization.controller;

import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OrganizationController {

    List<Organization> list(Organization organization);

    String loadById(Long id);

    String update(Organization organization);

    String save(Organization organization);

    String delete(Organization organization);
}
