package ru.bellintegrator.practice.countries.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.countries.model.Countries;
import ru.bellintegrator.practice.countries.service.CountriesService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountriesControllerImpl implements CountriesController {

    private final CountriesService countriesService;

    @Autowired
    public CountriesControllerImpl(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @Override
    @ApiOperation(value = "getCountries", nickname = "getCountries", httpMethod = "GET")
    @RequestMapping(value = "/countries", method = {GET})
    public List<Countries> countries() {
        return countriesService.countries();
    }
}
