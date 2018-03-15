package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.views.OfficeView;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OfficeDao {

    List<Office> list(OfficeView view);

    Office findOfficeById(Long id);

    void update(OfficeView view);

    void delete(Long id);

    void save(OfficeView view);
}
