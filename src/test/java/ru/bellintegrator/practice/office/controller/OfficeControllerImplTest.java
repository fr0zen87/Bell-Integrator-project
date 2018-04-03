package ru.bellintegrator.practice.office.controller;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.practice.office.views.requests.OfficeDeleteRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeFilter;
import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
import ru.bellintegrator.practice.office.views.requests.OfficeUpdateRequest;

import java.io.IOException;

import static org.junit.Assert.*;

public class OfficeControllerImplTest {

    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();
    private ResponseEntity<Object> responseEntity;

    {
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {

            }
        });
    }

    @Test
    public void list() {
        OfficeFilter filter = new OfficeFilter();
        filter.setOrgId(1L);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/office/list",
                new HttpEntity<>(filter, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void findOfficeById() {
        responseEntity = restTemplate.getForEntity("http://localhost:8888/api/office/1", Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void update() {
        OfficeUpdateRequest update = new OfficeUpdateRequest(1L, "1", "1", "1", false);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/office/update",
                new HttpEntity<>(update, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void delete() {
        OfficeDeleteRequest delete = new OfficeDeleteRequest(2L);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/office/delete",
                new HttpEntity<>(delete, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void save() {
        OfficeSaveRequest save = new OfficeSaveRequest("2", "2addr", "22", true, 1L);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/office/save",
                new HttpEntity<>(save, headers), Object.class);
        System.out.println(responseEntity);
    }
}