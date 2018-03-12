package ru.bellintegrator.practice.documents.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.documents.dao.DocTypeDao;
import ru.bellintegrator.practice.documents.model.DocType;

import java.util.List;

@Service
public class DocTypeServiceImpl implements DocTypeService {

    private final Logger log = LoggerFactory.getLogger(DocTypeServiceImpl.class);

    private final DocTypeDao dao;

    @Autowired
    public DocTypeServiceImpl(DocTypeDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocType> docs() {
        List<DocType> all = dao.docs();
        log.debug(all.toString());
        return dao.docs();
    }
}
