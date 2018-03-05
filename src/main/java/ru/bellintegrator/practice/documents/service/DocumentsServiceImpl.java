package ru.bellintegrator.practice.documents.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.documents.dao.DocumentsDAO;
import ru.bellintegrator.practice.documents.model.Documents;

import java.util.List;
import java.util.stream.Collectors;

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

        return all.stream()
                .map(d -> {
                    Documents docs = new Documents();
                    docs.setName(d.getName());
                    docs.setCode(d.getCode());

                    log.debug(docs.toString());

                    return docs;
                })
                .collect(Collectors.toList());
    }
}
