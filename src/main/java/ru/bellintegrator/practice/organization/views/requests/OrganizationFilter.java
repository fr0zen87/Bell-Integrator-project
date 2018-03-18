package ru.bellintegrator.practice.organization.views.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Organization filter class
 */
public class OrganizationFilter {

    @NotNull(message = "name must not be null")
    @Size(max = 50, message = "name length must be equals or less than 50")
    private String name;

    @Digits(integer = 10, fraction = 0, message = "only digits are available in inn")
    @Size(min = 10, max = 10, message = "inn length must be 10")
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
