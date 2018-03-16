package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.views.responces.OfficeListView;
import ru.bellintegrator.practice.office.views.responces.OfficeView;
import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeUpdateRequest;

import java.util.List;
import java.util.Map;

/**
 * Office service
 */
public interface OfficeService {

    /**
     * @param filters - filters to find offices
     * @return offices founded by filters
     */
    List<OfficeListView> list(Map<String, Object> filters);

    /**
     * @param id - office primary key
     * @return an office
     */
    OfficeView findOfficeById(Long id);

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
