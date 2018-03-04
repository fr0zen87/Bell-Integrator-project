package ru.bellintegrator.practice.myApp.docs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.myApp.docs.dao.DocsDAO;
import ru.bellintegrator.practice.myApp.docs.model.Docs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocsServiceImpl implements DocsService {

    private final Logger log = LoggerFactory.getLogger(DocsServiceImpl.class);

    private final DocsDAO dao;

    @Autowired
    public DocsServiceImpl(DocsDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docs> docs() {
        List<Docs> all = dao.docs();

        return all.stream()
                .map(d -> {
                    Docs docs = new Docs();
                    docs.setName(d.getName());
                    docs.setCode(d.getCode());

                    log.info(docs.toString());

                    return docs;
                })
                .collect(Collectors.toList());
    }
}
