package ru.bellintegrator.practice.office.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.service.OfficeService;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/office", produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {

    private final OfficeService officeService;

    public OfficeControllerImpl(OfficeService officeService) {
        this.officeService = officeService;
    }

    @Override
    public Map list(Office office) {
        return null;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map findOfficeById(@PathVariable("id") Long id) {
        try {
            return Collections.singletonMap("data", officeService.findOfficeById(id));
        } catch (Exception e) {
            return Collections.singletonMap("error", e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map update(@RequestBody @NotNull Office office) {
        try {
            officeService.update(office);
            return Collections.singletonMap("data", Collections.singletonMap("result","success"));
        } catch (Exception e) {
            return Collections.singletonMap("error", e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map delete(@RequestBody @NotNull Office office) {
        try {
            officeService.delete(office.getId());
            return Collections.singletonMap("data", Collections.singletonMap("result","success"));
        } catch (Exception e) {
            return Collections.singletonMap("error", e.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map save(@RequestBody @NotNull Office office) {
        try {
            officeService.save(office);
            return Collections.singletonMap("data", Collections.singletonMap("result","success"));
        } catch (Exception e) {
            return Collections.singletonMap("error", e.getCause().getMessage());
        }
    }
}
