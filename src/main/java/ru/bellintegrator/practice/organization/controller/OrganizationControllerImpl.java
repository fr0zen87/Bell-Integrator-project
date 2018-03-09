package ru.bellintegrator.practice.organization.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/api/organization", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {

    private final OrganizationService organizationService;
    private final String SUCCESS_MESSAGE = "{\r\n\"result\":\"success\"\r\n}";

    @Autowired
    public OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    @RequestMapping(value = "/list",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public List<Organization> list(@RequestBody @NotNull Organization organization) {
        return organizationService.list(organization.getName(),
                organization.getInn(), organization.isActive());
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String loadById(@PathVariable("id") Long id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(organizationService.loadById(id));
        } catch (Exception e) {
            return  "{\r\n\"error\":\"" + e.getMessage() + "\"\r\n}";
        }
    }

    @Override
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody @NotNull Organization organization) {
        try {
            organizationService.update(organization);
            return SUCCESS_MESSAGE;
        } catch (Exception e) {
            return  "{\r\n\"error\":\"" + e.getMessage() + "\"\r\n}";
        }
    }

    @Override
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody @NotNull Organization organization) {
        try {
            organizationService.save(organization);
            return SUCCESS_MESSAGE;
        } catch (Exception e) {
            return  "{\r\n\"error\":\"" + e.getCause().getMessage() + "\"\r\n}";
        }
    }

    @Override
    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@RequestBody @NotNull Organization organization) {
        try {
            organizationService.delete(organization.getId());
            return SUCCESS_MESSAGE;
        } catch (Exception e) {
            return  "{\r\n\"error\":\"" + e.getMessage() + "\"\r\n}";
        }
    }
}
