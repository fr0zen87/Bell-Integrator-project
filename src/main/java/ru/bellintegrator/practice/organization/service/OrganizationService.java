package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OrganizationService {

    List<Organization> list(String name, String inn, boolean isActive);

    Organization loadById(Long id);

    String update(Organization organization);

    String save(Organization organization);

    String delete(Long id);
}
