package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.views.requests.OrganizationDeleteRequest;
import ru.bellintegrator.practice.organization.views.requests.OrganizationFilter;
import ru.bellintegrator.practice.organization.views.requests.OrganizationSaveRequest;
import ru.bellintegrator.practice.organization.views.requests.OrganizationUpdateRequest;

import javax.validation.Valid;
import java.util.Collections;

/**
 * {@inheritDoc}
 */
@RestController
@RequestMapping(value = "/api/organization", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    @RequestMapping(value = "/list",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Object> list(@RequestBody @Valid OrganizationFilter filter) {

        return ResponseEntity.ok(Collections.singletonMap("data", organizationService.list(filter)));
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> loadById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(Collections.singletonMap("data", organizationService.loadById(id)));
    }

    @Override
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody @Valid OrganizationUpdateRequest update) {

        organizationService.update(update);
        return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }

    @Override
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody @Valid OrganizationSaveRequest save) {

        organizationService.save(save);
        return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }

    @Override
    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@RequestBody @Valid OrganizationDeleteRequest delete) {

        organizationService.delete(delete.getId());
        return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }
}
