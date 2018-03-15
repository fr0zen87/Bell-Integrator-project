package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.views.OrganizationView;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OrganizationDao {

    List<Organization> list(OrganizationView view);

    Organization loadById(Long id);

    void update(OrganizationView view);

    void save(OrganizationView view);

    void delete(Long id);
}
