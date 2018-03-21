package ru.bellintegrator.practice.user.views.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.util.Date;

public class UserUpdateRequest {

    @NotNull(message = "id must not be null")
    @Min(value = 1, message = "id must be more than 0")
    private Long id;

    @NotNull(message = "firstName is required")
    @Size(max = 20, message = "firstName length must be equals or less than 20 symbols")
    private String firstName;

    @NotNull(message = "secondName is required")
    @Size(max = 20, message = "secondName length must be equals or less than 20 symbols")
    private String secondName;

    @NotNull(message = "middleName is required")
    @Size(max = 20, message = "middleName length must be equals or less than 20 symbols")
    private String middleName;

    @NotNull(message = "position is required")
    @Size(max = 255, message = "position length must be equals or less than 255 symbols")
    private String position;

    @NotNull(message = "phone is required")
    @Digits(integer = 12, fraction = 0, message = "only digits are available in phone")
    @Size(max = 12, message = "phone length must be equals or less than 12")
    private String phone;

    @NotNull(message = "docCode is required")
    @Digits(integer = 2, fraction = 0, message = "only digits are available in docCode")
    @Size(min = 2, max = 2, message = "docCode length must be 2 symbols")
    private String docCode;

    @NotNull(message = "docName is required")
    @Size(max = 255, message = "docName length must be equals or less than 255")
    private String docName;

    @NotNull(message = "docNumber is required")
    @Digits(integer = 20, fraction = 0, message = "only digits are available in docCode")
    @Size(max = 20, message = "docNumber length must be equals or less than 20")
    private String docNumber;

    @NotNull(message = "docDate is required")
    @Past
    private Date docDate;

    @NotNull(message = "citizenshipName is required")
    @Size(max = 255, message = "citizenshipName length must be equals or less than 255 symbols")
    private String citizenshipName;

    @NotNull(message = "citizenshipCode is required")
    @Digits(integer = 3, fraction = 0, message = "only digits are available in citizenshipCode")
    @Size(min = 3, max = 3, message = "citizenshipCode length must be 3 symbols")
    private String citizenshipCode;

    @NotNull(message = "isIdentified is required")
    @JsonProperty(value = "isIdentified")
    private Boolean isIdentified;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public String getDocCode() {
        return docCode;
    }

    public String getDocName() {
        return docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    @JsonGetter(value = "isIdentified")
    public Boolean getIdentified() {
        return isIdentified;
    }
}
