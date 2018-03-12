package ru.bellintegrator.practice.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;

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
    public List<Office> list(Office office) {
        return null;
    }

    @Override
    @Transactional (readOnly = true)
    public Office findOfficeById(Long id) {
        Office result = dao.findOfficeById(id);
        log.debug(result.toString());
        return result;
    }

    @Override
    @Transactional
    public Office update(Office office) {
        Office result = dao.update(office);
        log.debug(result.toString());
        return result;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void save(Office office) {
        dao.save(office);
    }
}
