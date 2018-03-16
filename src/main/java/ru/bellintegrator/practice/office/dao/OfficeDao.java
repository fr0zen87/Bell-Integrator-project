package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.views.requests.OfficeFilter;
import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeUpdateRequest;

import java.util.List;

/**
 * Dao to work with office
 */
public interface OfficeDao {

    /**
     * @param filter - filter to find offices
     * @return offices founded by filter
     */
    List<Office> list(OfficeFilter filter);

    /**
     * @param id - office primary key
     * @return an office
     */
    Office findOfficeById(Long id);

    /**
     * @param update - office to update
     */
    void update(OfficeUpdateRequest update);

    /**
     * @param id - office primary key
     */
    void delete(Long id);

    /**
     * @param save - office to save
     */
    void save(OfficeSaveRequest save);
}
