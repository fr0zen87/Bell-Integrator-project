package ru.bellintegrator.practice.office.views.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OfficeFilter {

    @JsonProperty(required = true)
    private Long orgId;

    private String name;

    private String phone;

    @JsonProperty(value = "isActive")
    private Boolean isActive;

    public Long getOrgId() {
        return orgId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @JsonGetter(value = "isActive")
    Boolean getActive() {
        return isActive;
    }
}
