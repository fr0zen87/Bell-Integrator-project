package ru.bellintegrator.practice.documents.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.documents.dao.DocumentsDAO;
import ru.bellintegrator.practice.documents.model.Documents;

import java.util.List;

@Service
public class DocumentsServiceImpl implements DocumentsService {

    private final Logger log = LoggerFactory.getLogger(DocumentsServiceImpl.class);

    private final DocumentsDAO dao;

    @Autowired
    public DocumentsServiceImpl(DocumentsDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Documents> docs() {
        List<Documents> all = dao.docs();
        log.debug(all.toString());
        return dao.docs();
    }
}
