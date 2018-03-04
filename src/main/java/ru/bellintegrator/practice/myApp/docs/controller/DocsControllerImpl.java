package ru.bellintegrator.practice.myApp.docs.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.myApp.docs.model.Docs;
import ru.bellintegrator.practice.myApp.docs.service.DocsService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocsControllerImpl implements DocsController {

    private final DocsService docsService;

    @Autowired
    public DocsControllerImpl(DocsService docsService) {
        this.docsService = docsService;
    }

    @Override
    @ApiOperation(value = "getDocs", nickname = "getDocs", httpMethod = "POST")
    @RequestMapping(value = "/docs", method = {POST})
    public List<Docs> docs() {
        return docsService.docs();
    }
}
