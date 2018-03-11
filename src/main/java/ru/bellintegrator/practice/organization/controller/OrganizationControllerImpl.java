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

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Map;

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
    public Map list(@RequestBody @NotNull Organization organization) {
        try {
            if (organization.getName() == null) {
                throw new Exception("Name is required");
            }
            return Collections.singletonMap("data", organizationService.list(organization.getName(),
                    organization.getInn(), organization.isActive()));
        } catch (Exception e) {
            return Collections.singletonMap("error", e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map loadById(@PathVariable("id") Long id) {
        try {
            return Collections.singletonMap("data", organizationService.loadById(id));
        } catch (Exception e) {
            return Collections.singletonMap("error", e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map update(@RequestBody @NotNull Organization organization) {
        try {
            organizationService.update(organization);
            return Collections.singletonMap("data", Collections.singletonMap("result","success"));
        } catch (Exception e) {
            return Collections.singletonMap("error", e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map save(@RequestBody @NotNull Organization organization) {
        try {
            organizationService.save(organization);
            return Collections.singletonMap("data", Collections.singletonMap("result","success"));
        } catch (Exception e) {
            return Collections.singletonMap("error", e.getCause().getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map delete(@RequestBody @NotNull Organization organization) {
        try {
            organizationService.delete(organization.getId());
            return Collections.singletonMap("data", Collections.singletonMap("result","success"));
        } catch (Exception e) {
            return Collections.singletonMap("error", e.getMessage());
        }
    }
}
