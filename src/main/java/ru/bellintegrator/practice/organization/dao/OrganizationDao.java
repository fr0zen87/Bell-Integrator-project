package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.views.OrganizationView;

import java.util.List;

/**
 * Dao to work with Organization
 */
public interface OrganizationDao {

    /**
     * @param view - filter to find organizations
     * @return organizations founded by filter
     */
    List<Organization> list(OrganizationView view);

    /**
     * @param id - organization primary key
     * @return an organization
     */
    Organization loadById(Long id);

    /**
     * @param view - organization to update
     */
    void update(OrganizationView view);

    /**
     * @param view - organization to save
     */
    void save(OrganizationView view);

    /**
     * @param id - organization primary key
     */
    void delete(Long id);
}
