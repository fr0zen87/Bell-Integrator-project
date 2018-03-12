package ru.bellintegrator.practice.countries.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.countries.service.CountryService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryControllerImpl implements CountryController {

    private final CountryService countriesService;

    @Autowired
    public CountryControllerImpl(CountryService countriesService) {
        this.countriesService = countriesService;
    }

    @Override
    @ApiOperation(value = "getCountries", nickname = "getCountries", httpMethod = "GET")
    @RequestMapping(value = "/countries", method = {GET})
    public List<Country> countries() {
        return countriesService.countries();
    }
}
