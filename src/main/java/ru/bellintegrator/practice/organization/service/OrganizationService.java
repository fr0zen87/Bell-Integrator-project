package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.views.OrganizationListView;
import ru.bellintegrator.practice.organization.views.OrganizationView;

import java.util.List;

/**
 * Organization service
 */
public interface OrganizationService {

    /**
     * @param view - filter parameter
     * @return list of organizations
     */
    List<OrganizationListView> list(OrganizationView view);

    /**
     * @param id - primary key of organization
     * @return an organization
     */
    OrganizationView loadById(Long id);

    /**
     * @param view - organization to update
     */
    void update(OrganizationView view);

    /**
     * @param view - organization to save
     */
    void save(OrganizationView view);

    /**
     * @param id - primary key of organization to delete
     */
    void delete(Long id);
}
