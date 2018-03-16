package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.views.OfficeView;

import java.util.List;

/**
 * Dao to work with office
 */
public interface OfficeDao {

    /**
     * @param view - filter to find offices
     * @return offices founded by filter
     */
    List<Office> list(OfficeView view);

    /**
     * @param id - office primary key
     * @return an office
     */
    Office findOfficeById(Long id);

    /**
     * @param view - office to update
     */
    void update(OfficeView view);

    /**
     * @param id - office primary key
     */
    void delete(Long id);

    /**
     * @param view - office to save
     */
    void save(OfficeView view);
}
