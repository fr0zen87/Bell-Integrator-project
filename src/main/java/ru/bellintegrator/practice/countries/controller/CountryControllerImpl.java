package ru.bellintegrator.practice.countries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.countries.views.CountryView;
import ru.bellintegrator.practice.countries.service.CountryService;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryControllerImpl implements CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryControllerImpl(CountryService countriesService) {
        this.countryService = countriesService;
    }

    @Override
    @RequestMapping(value = "/countries", method = {GET})
    public Map<String, List<CountryView>> countries() {
        return countryService.countries();
    }
}
