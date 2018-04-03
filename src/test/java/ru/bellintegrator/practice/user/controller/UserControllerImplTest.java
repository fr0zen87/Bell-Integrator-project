package ru.bellintegrator.practice.user.controller;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.practice.user.views.requests.UserDeleteRequest;
import ru.bellintegrator.practice.user.views.requests.UserFilter;
import ru.bellintegrator.practice.user.views.requests.UserSaveRequest;
import ru.bellintegrator.practice.user.views.requests.UserUpdateRequest;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

public class UserControllerImplTest {

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
        UserFilter filter = new UserFilter();
        filter.setOfficeId(1L);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/user/list",
                new HttpEntity<>(filter, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void loadById() {
        responseEntity = restTemplate.getForEntity("http://localhost:8888/api/user/2", Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void update() {
        UserUpdateRequest update = new UserUpdateRequest(1L, "fname", "sname",
                "mname", "pos", "12345", "07", "Военный билет",
                "11111111", new Date(), "Италия", "380", true);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/user/update",
                new HttpEntity<>(update, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void delete() {
        UserDeleteRequest delete = new UserDeleteRequest(1L);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/user/delete",
                new HttpEntity<>(delete, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void save() {
        UserSaveRequest save = new UserSaveRequest("fname", "sname",
                "mname", "pos", "12345", "07", "Военный билет",
                "11111111", new Date(), "Италия", "380", true, 1L);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/user/save",
                new HttpEntity<>(save, headers), Object.class);
        System.out.println(responseEntity);
    }
}