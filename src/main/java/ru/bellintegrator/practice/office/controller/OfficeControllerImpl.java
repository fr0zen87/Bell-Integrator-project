package ru.bellintegrator.practice.office.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.views.requests.OfficeDeleteRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeFilter;
import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeUpdateRequest;

import javax.validation.constraints.NotNull;
import java.util.Collections;

/**
 * {@inheritDoc}
 */
@RestController
@RequestMapping(value = "/api/office", produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {

    private final OfficeService officeService;

    public OfficeControllerImpl(OfficeService officeService) {
        this.officeService = officeService;
    }

    @Override
    @RequestMapping(value = "/list/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> list(@RequestBody OfficeFilter filter) {
        // TODO: 16.03.2018 add filter
        return null;
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findOfficeById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(Collections.singletonMap("data", officeService.findOfficeById(id)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @Override
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody @NotNull OfficeUpdateRequest update) {
        try {
            officeService.update(update);
            return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result","success")));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @Override
    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@RequestBody @NotNull OfficeDeleteRequest delete) {
        try {
            officeService.delete(delete.getId());
            return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result","success")));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @Override
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody @NotNull OfficeSaveRequest save) {
        try {
            officeService.save(save);
            return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result","success")));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
