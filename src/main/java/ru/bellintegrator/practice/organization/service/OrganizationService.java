package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.views.responces.OrganizationListView;
import ru.bellintegrator.practice.organization.views.requests.OrganizationFilter;
import ru.bellintegrator.practice.organization.views.requests.OrganizationSaveRequest;
import ru.bellintegrator.practice.organization.views.requests.OrganizationUpdateRequest;
import ru.bellintegrator.practice.organization.views.responces.OrganizationView;

import java.util.List;

/**
 * Organization service
 */
public interface OrganizationService {

    /**
     * @param filter - filter parameter
     * @return list of organizations
     */
    List<OrganizationListView> list(OrganizationFilter filter);

    /**
     * @param id - primary key of organization
     * @return an organization
     */
    OrganizationView loadById(Long id);

    /**
     * @param update - organization to update
     */
    void update(OrganizationUpdateRequest update);

    /**
     * @param save - organization to save
     */
    void save(OrganizationSaveRequest save);

    /**
     * @param id - primary key of organization to delete
     */
    void delete(Long id);
}
