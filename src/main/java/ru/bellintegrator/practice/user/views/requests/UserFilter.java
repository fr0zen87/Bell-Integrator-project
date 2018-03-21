package ru.bellintegrator.practice.user.views.requests;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Request class to filter users
 */
public class UserFilter {

    @NotNull(message = "officeId is required")
    @Min(value = 1, message = "officeId must be more than 0")
    private Long officeId;

    @Size(max = 20, message = "firstName length must be equals or less than 20 symbols")
    private String firstName;

    @Size(max = 20, message = "secondName length must be equals or less than 20 symbols")
    private String secondName;

    @Size(max = 20, message = "middleName length must be equals or less than 20 symbols")
    private String middleName;

    @Size(max = 255, message = "position length must be equals or less than 255 symbols")
    private String position;

    @Digits(integer = 3, fraction = 0, message = "only digits are available in citizenshipCode")
    @Size(min = 3, max = 3, message = "citizenshipCode length must be 3 symbols")
    private String citizenshipCode;

    @Digits(integer = 2, fraction = 0, message = "only digits are available in docCode")
    @Size(min = 2, max = 2, message = "docCode length must be 2 symbols")
    private String docCode;

    public Long getOfficeId() {
        return officeId;
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

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public String getDocCode() {
        return docCode;
    }
}
