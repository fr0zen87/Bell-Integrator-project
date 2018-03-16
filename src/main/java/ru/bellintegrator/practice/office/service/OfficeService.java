package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.views.responces.OfficeListView;
import ru.bellintegrator.practice.office.views.responces.OfficeView;
import ru.bellintegrator.practice.office.views.requests.OfficeFilter;
import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeUpdateRequest;

import java.util.List;

/**
 * Office service
 */
public interface OfficeService {

    /**
     * @param filter - filter to find offices
     * @return offices founded by filter
     */
    List<OfficeListView> list(OfficeFilter filter);

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
