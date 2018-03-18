package ru.bellintegrator.practice.office.views.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Request class to save office
 */
public class OfficeSaveRequest {

    @NotNull(message = "name must not be null")
    @Size(max = 50, message = "name length must be less than 50")
    private String name;

    @NotNull(message = "address must not be null")
    @Size(max = 255, message = "address length must be less than 255")
    private String address;

    @NotNull(message = "phone must not be null")
    @Digits(integer = 12, fraction = 0, message = "only digits are available in phone")
    @Size(max = 12, message = "phone length must be less than 12")
    private String phone;

    @NotNull(message = "isActive must not be null")
    @JsonProperty(value = "isActive")
    private Boolean isActive;

    @NotNull(message = "orgId must not be null")
    @Min(value = 1, message = "orgId must be more than 0")
    private Long orgId;

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

    public Long getOrgId() {
        return orgId;
    }
}
