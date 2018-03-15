package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.views.OfficeView;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface OfficeService {

    List<Office> list(OfficeView view);

    OfficeView findOfficeById(Long id);

    void update(OfficeView view);

    void delete(Long id);

    void save(OfficeView view);
}
