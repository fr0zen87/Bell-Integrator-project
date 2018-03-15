package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.views.RequestView;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OrganizationDao {

    List<Organization> list(RequestView view);

    Organization loadById(Long id);

    void update(RequestView view);

    void save(RequestView view);

    void delete(Long id);
}
