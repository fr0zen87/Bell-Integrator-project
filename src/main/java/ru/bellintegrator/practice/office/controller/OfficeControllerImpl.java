package ru.bellintegrator.practice.office.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.MyError;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.service.OfficeService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/api/office", produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {

    private final OfficeService officeService;
    private final String SUCCESS_MESSAGE = "{\r\n\"result\":\"success\"\r\n}";

    public OfficeControllerImpl(OfficeService officeService) {
        this.officeService = officeService;
    }

    @Override
    public List<Office> list(Office office) {
        return null;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findOfficeById(@PathVariable("id") Long id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(officeService.findOfficeById(id));
        } catch (Exception e) {
            return new MyError(e.getMessage()).toString();
        }
    }

    @Override
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody @NotNull Office office) {
        try {
            officeService.update(office);
            return SUCCESS_MESSAGE;
        } catch (Exception e) {
            return new MyError(e.getMessage()).toString();
        }
    }

    @Override
    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@RequestBody @NotNull Office office) {
        try {
            officeService.delete(office.getId());
            return SUCCESS_MESSAGE;
        } catch (Exception e) {
            return new MyError(e.getMessage()).toString();
        }
    }

    @Override
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody @NotNull Office office) {
        try {
            officeService.save(office);
            return SUCCESS_MESSAGE;
        } catch (Exception e) {
            return new MyError(e.getCause().getMessage()).toString();
        }
    }
}
