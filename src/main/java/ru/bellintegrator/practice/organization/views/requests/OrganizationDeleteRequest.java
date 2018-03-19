package ru.bellintegrator.practice.organization.views.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Request class to delete organization
 */
public class OrganizationDeleteRequest {

    @NotNull(message = "id is required")
    @Min(value = 1, message = "id must be more than 0")
    private Long id;

    public Long getId() {
        return id;
    }
}
