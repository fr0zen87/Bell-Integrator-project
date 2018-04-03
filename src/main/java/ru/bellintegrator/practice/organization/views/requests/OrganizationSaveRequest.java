package ru.bellintegrator.practice.organization.views.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Request class to save organization
 */
public class OrganizationSaveRequest {

    @NotNull(message = "name is required")
    @Size(max = 50, message = "name length must be equals or less than 50 symbols")
    private String name;

    @NotNull(message = "fullName is required")
    @Size(max = 255, message = "fullName length must be equals or less than 255 symbols")
    private String fullName;

    @NotNull(message = "inn is required")
    @Digits(integer = 10, fraction = 0, message = "only digits are available in inn")
    @Size(min = 10, max = 10, message = "inn length must be 10")
    private String inn;

    @NotNull(message = "kpp is required")
    @Digits(integer = 9, fraction = 0, message = "only digits are available in kpp")
    @Size(min = 9, max = 9, message = "kpp length must be 9")
    private String kpp;

    @NotNull(message = "address is required")
    @Size(max = 255, message = "address length must be equals or less than 255 symbols")
    private String address;

    @NotNull(message = "phone is required")
    @Digits(integer = 12, fraction = 0, message = "only digits are available in phone")
    @Size(max = 12, message = "phone length must be less than 12")
    private String phone;

    @NotNull(message = "isActive is required")
    @JsonProperty(value = "isActive")
    private Boolean isActive;

    public OrganizationSaveRequest() {
    }

    public OrganizationSaveRequest(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
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
