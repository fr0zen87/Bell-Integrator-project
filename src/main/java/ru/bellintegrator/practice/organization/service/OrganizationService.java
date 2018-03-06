package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OrganizationService {

    List<Organization> list(String name, String inn, boolean isActive);

    Organization loadById(Long id);

    Organization update(Organization organization);

    void save(Organization organization);

    void delete(Long id);
}
