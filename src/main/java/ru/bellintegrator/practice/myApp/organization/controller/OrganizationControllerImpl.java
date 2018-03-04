package ru.bellintegrator.practice.myApp.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.myApp.organization.model.Organization;
import ru.bellintegrator.practice.myApp.organization.service.OrganizationService;

import java.util.List;

@RestController
@RequestMapping(value = "/organization", produces = MediaType.APPLICATION_JSON_VALUE)
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
    @ResponseBody
    public List<String> list(@RequestBody Organization organization) {
        return organizationService.list(organization.getName(), organization.getInn(), organization.isActive());
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Organization loadById(@PathVariable("id") Long id) {
        return organizationService.loadById(id);
    }

    @Override
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String update(@RequestBody Organization organization) {
        return organizationService.update(organization);
    }

    @Override
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String save(@RequestBody Organization organization) {
        return organizationService.save(organization);
    }

    @Override
    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete(@RequestBody Organization organization) {
        return organizationService.delete(organization.getId());
    }
}
