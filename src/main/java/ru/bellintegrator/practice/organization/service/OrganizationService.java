package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.views.OrganizationView;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OrganizationService {

    List<OrganizationView> list(String name, String inn, boolean isActive);

    Organization loadById(Long id);

    Organization update(Organization organization);

    void save(Organization organization);

    void delete(Long id);
}
