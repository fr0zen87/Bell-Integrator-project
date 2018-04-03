package ru.bellintegrator.practice.office.views.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Request class to filter offices
 */
public class OfficeFilter {

    @NotNull(message = "orgId is required")
    @Min(value = 1, message = "orgId must be more than 0")
    private Long orgId;

    @Size(max = 50, message = "name length must be equals or less than 50 symbols")
    private String name;

    @Digits(integer = 12, fraction = 0, message = "only digits are available in phone")
    @Size(max = 12, message = "phone length must be less than 12")
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

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
