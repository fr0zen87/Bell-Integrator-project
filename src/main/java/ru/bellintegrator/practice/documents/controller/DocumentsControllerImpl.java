package ru.bellintegrator.practice.documents.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.documents.model.Documents;
import ru.bellintegrator.practice.documents.service.DocumentsService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentsControllerImpl implements DocumentsController {

    private final DocumentsService docsService;

    @Autowired
    public DocumentsControllerImpl(DocumentsService docsService) {
        this.docsService = docsService;
    }

    @Override
    @ApiOperation(value = "getDocs", nickname = "getDocs", httpMethod = "GET")
    @RequestMapping(value = "/docs", method = {GET})
    public List<Documents> docs() {
        return docsService.docs();
    }
}
