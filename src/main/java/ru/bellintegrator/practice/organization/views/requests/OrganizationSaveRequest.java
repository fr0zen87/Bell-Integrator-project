package ru.bellintegrator.practice.organization.views.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request class to save organization
 */
public class OrganizationSaveRequest {

    private String name;

    private String fullName;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    @JsonProperty(value = "isActive")
    private Boolean isActive;

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
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
