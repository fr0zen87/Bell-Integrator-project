package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.views.ResponseView;
import ru.bellintegrator.practice.organization.views.OrganizationView;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OrganizationService {

    List<ResponseView> list(OrganizationView view);

    OrganizationView loadById(Long id);

    void update(OrganizationView view);

    void save(OrganizationView view);

    void delete(Long id);
}
