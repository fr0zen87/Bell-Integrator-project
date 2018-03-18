package ru.bellintegrator.practice.organization.views.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Request class to update organization
 */
public class OrganizationUpdateRequest {

    @NotNull(message = "id must not be null")
    @Min(value = 1, message = "id must be more than 0")
    private Long id;

    @NotNull(message = "name must not be null")
    @Size(max = 50, message = "name length must be less than 50")
    private String name;

    @NotNull(message = "fullName must not be null")
    @Size(max = 255, message = "fullName length must be less than 255")
    private String fullName;

    @NotNull(message = "inn must not be null")
    @Digits(integer = 10, fraction = 0, message = "only digits are available in inn")
    @Size(min = 10, max = 10, message = "inn length must be 10")
    private String inn;

    @NotNull(message = "kpp must not be null")
    @Digits(integer = 9, fraction = 0, message = "only digits are available in kpp")
    @Size(min = 9, max = 9, message = "kpp length must be 9")
    private String kpp;

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

    public Long getId() {
        return id;
    }

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
