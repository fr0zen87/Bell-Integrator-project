package ru.bellintegrator.practice.organization.views.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Organization filter class
 */
public class OrganizationFilter {

    @JsonProperty(required = true)
    private String name;

    private String inn;

    @JsonProperty(value = "isActive")
    private Boolean isActive;

    public String getName() {
        return name;
    }

    public String getInn() {
        return inn;
    }

    @JsonGetter(value = "isActive")
    public Boolean getActive() {
        return isActive;
    }
}
