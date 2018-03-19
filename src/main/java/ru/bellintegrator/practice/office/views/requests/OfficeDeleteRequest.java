package ru.bellintegrator.practice.office.views.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Request class to delete office
 */
public class OfficeDeleteRequest {

    @NotNull(message = "id is required")
    @Min(value = 1, message = "id must be more than 0")
    private Long id;

    public Long getId() {
        return id;
    }
}
