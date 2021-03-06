package ru.bellintegrator.practice.doctype.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.doctype.dao.DocTypeDao;
import ru.bellintegrator.practice.doctype.views.DocTypeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}
 */
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
    public Map<String, List<DocTypeView>> documents() {

        Map<String, List<DocTypeView>> result = new HashMap<>();
        List<DocTypeView> docTypeViews = new ArrayList<>();
        dao.findAll().forEach(docType -> {
            DocTypeView docTypeView = new DocTypeView();
            docTypeView.setName(docType.getName());
            docTypeView.setCode(docType.getCode());
            log.debug(docTypeView.toString());
            docTypeViews.add(docTypeView);
        });
        result.put("data", docTypeViews);
        return result;
    }
}
