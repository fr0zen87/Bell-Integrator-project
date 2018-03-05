package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationService;

import java.util.List;

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
    public List<Organization> list(@RequestBody Organization organization) {
        return organizationService.list(organization.getName(),
                organization.getInn(), organization.isActive());
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Organization loadById(@PathVariable("id") Long id) {
        return organizationService.loadById(id);
    }

    @Override
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody Organization organization) {
        return organizationService.update(organization);
    }

    @Override
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody Organization organization) {
        return organizationService.save(organization);
    }

    @Override
    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@RequestBody Organization organization) {
        return organizationService.delete(organization.getId());
    }
}
