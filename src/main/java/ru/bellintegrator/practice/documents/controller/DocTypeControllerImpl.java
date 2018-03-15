package ru.bellintegrator.practice.documents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.documents.service.DocTypeService;
import ru.bellintegrator.practice.documents.views.DocTypeView;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * {@inheritDoc}
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocTypeControllerImpl implements DocTypeController {

    private final DocTypeService docTypeService;

    @Autowired
    public DocTypeControllerImpl(DocTypeService docsService) {
        this.docTypeService = docsService;
    }

    @Override
    @RequestMapping(value = "/docs", method = {GET})
    public Map<String, List<DocTypeView>> documents() {
        return docTypeService.documents();
    }
}
