package ru.bellintegrator.practice.office.views.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request class to update office
 */
public class OfficeUpdateRequest {

    private Long id;

    private String name;

    private String address;

    private String phone;

    @JsonProperty(value = "isActive")
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @JsonGetter(value = "isActive")
    public Boolean getActive() {
        return isActive;
    }
}
