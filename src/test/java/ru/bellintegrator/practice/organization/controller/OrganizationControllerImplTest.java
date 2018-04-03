package ru.bellintegrator.practice.organization.controller;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.practice.organization.views.requests.OrganizationDeleteRequest;
import ru.bellintegrator.practice.organization.views.requests.OrganizationFilter;
import ru.bellintegrator.practice.organization.views.requests.OrganizationSaveRequest;
import ru.bellintegrator.practice.organization.views.requests.OrganizationUpdateRequest;

import java.io.IOException;

import static org.junit.Assert.*;

public class OrganizationControllerImplTest {

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
        OrganizationFilter filter = new OrganizationFilter();
        filter.setName("TestOrg");
        filter.setInn("1111111111");
        filter.setActive(true);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/organization/list",
                new HttpEntity<>(filter, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void loadById() {
        responseEntity = restTemplate.getForEntity(
                "http://localhost:8888/api/organization/1", Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void update() {
        OrganizationUpdateRequest update = new OrganizationUpdateRequest(
                2L, "qwert", "qwert", "0000000000", "111111111", "qwert", "00000", false);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/organization/update",
                new HttpEntity<>(update, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void save() {
        OrganizationSaveRequest update = new OrganizationSaveRequest(
                "qwert", "qwerty", "0000000000", "111111111", "qwert", "00000", false);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/organization/save",
                new HttpEntity<>(update, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void delete() {
        OrganizationDeleteRequest delete = new OrganizationDeleteRequest(3L);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/organization/delete",
                new HttpEntity<>(delete, headers), Object.class);
        System.out.println(responseEntity);
    }
}