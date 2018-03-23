package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeUpdateRequest;

import java.util.List;
import java.util.Map;

/**
 * Dao to work with office
 */
public interface OfficeDao {

    /**
     * @param filters - filters to find offices
     * @return offices founded by filters
     */
    List<Object[]> list(Map<String, Object> filters);

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
