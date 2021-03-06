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
import ru.bellintegrator.practice.office.views.requests.OfficeFilterHelper;
import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeUpdateRequest;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

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
    @RequestMapping(value = "/list",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> list(@RequestBody @Valid OfficeFilter filter) {

        Map<String, Object> filters = OfficeFilterHelper.getFilters(filter);
        return ResponseEntity.ok().body(Collections.singletonMap("data", officeService.list(filters)));
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findOfficeById(@PathVariable("id") Long id) throws Exception {

        if (id < 1) throw new Exception("id must be greater than 0");
        return ResponseEntity.ok().body(Collections.singletonMap("data", officeService.findOfficeById(id)));
    }

    @Override
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody @Valid OfficeUpdateRequest update) {

        officeService.update(update);
        return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }

    @Override
    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@RequestBody @Valid OfficeDeleteRequest delete) {

        officeService.delete(delete.getId());
        return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }

    @Override
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody @Valid OfficeSaveRequest save) {

        officeService.save(save);
        return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }
}
