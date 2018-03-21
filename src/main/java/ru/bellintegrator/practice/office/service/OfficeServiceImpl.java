package ru.bellintegrator.practice.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.views.responces.OfficeListView;
import ru.bellintegrator.practice.office.views.responces.OfficeView;
import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeUpdateRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeDao dao;

    public OfficeServiceImpl(OfficeDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional (readOnly = true)
    public List<OfficeListView> list(Map<String, Object> filters) {
        List<OfficeListView> officeViews = new ArrayList<>();
        dao.list(filters).forEach(office -> {
            OfficeListView view = new OfficeListView();
            view.setId(office.getId());
            view.setName(office.getName());
            view.setActive(office.getActive());
            log.debug(view.toString());
            officeViews.add(view);
        });
        return officeViews;
    }

    @Override
    @Transactional (readOnly = true)
    public OfficeView findOfficeById(Long id) {
        OfficeView view = new OfficeView(dao.findOfficeById(id));
        log.debug(view.toString());
        return view;
    }

    @Override
    @Transactional
    public void update(OfficeUpdateRequest update) {
        dao.update(update);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void save(OfficeSaveRequest save) {
        dao.save(save);
    }
}
