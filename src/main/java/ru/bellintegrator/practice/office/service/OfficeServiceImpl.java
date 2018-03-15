package ru.bellintegrator.practice.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.views.OfficeView;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeDao dao;

    public OfficeServiceImpl(OfficeDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Office> list(OfficeView view) {
        return null;
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
    public void update(OfficeView view) {
        dao.update(view);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void save(OfficeView view) {
        dao.save(view);
    }
}
