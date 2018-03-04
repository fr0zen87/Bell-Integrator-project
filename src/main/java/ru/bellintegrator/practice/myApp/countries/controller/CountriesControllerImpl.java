package ru.bellintegrator.practice.myApp.countries.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.myApp.countries.model.Countries;
import ru.bellintegrator.practice.myApp.countries.service.CountriesService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountriesControllerImpl implements CountriesController {

    private final CountriesService countriesService;

    @Autowired
    public CountriesControllerImpl(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @Override
    @ApiOperation(value = "getCountries", nickname = "getCountries", httpMethod = "POST")
    @RequestMapping(value = "/countries", method = {POST})
    public List<Countries> countries() {
        return countriesService.countries();
    }
}
