package ru.bellintegrator.practice.documents.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.documents.model.DocType;
import ru.bellintegrator.practice.documents.service.DocTypeService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocTypeControllerImpl implements DocTypeController {

    private final DocTypeService docsService;

    @Autowired
    public DocTypeControllerImpl(DocTypeService docsService) {
        this.docsService = docsService;
    }

    @Override
    @ApiOperation(value = "getDocs", nickname = "getDocs", httpMethod = "GET")
    @RequestMapping(value = "/docs", method = {GET})
    public List<DocType> docs() {
        return docsService.docs();
    }
}
