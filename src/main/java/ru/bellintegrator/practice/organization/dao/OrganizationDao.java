package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.views.requests.OrganizationFilter;
import ru.bellintegrator.practice.organization.views.requests.OrganizationSaveRequest;
import ru.bellintegrator.practice.organization.views.requests.OrganizationUpdateRequest;

import java.util.List;

/**
 * Dao to work with Organization
 */
public interface OrganizationDao {

    /**
     * @param filter - filter to find organizations
     * @return organizations founded by filter
     */
    List<Organization> list(OrganizationFilter filter);

    /**
     * @param id - organization primary key
     * @return an organization
     */
    Organization loadById(Long id);

    /**
     * @param update - organization to update
     */
    void update(OrganizationUpdateRequest update);

    /**
     * @param save - organization to save
     */
    void save(OrganizationSaveRequest save);

    /**
     * @param id - organization primary key
     */
    void delete(Long id);
}
