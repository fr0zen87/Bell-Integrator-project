package ru.bellintegrator.practice.user.views.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Request class to delete user
 */
public class UserDeleteRequest {

    @NotNull(message = "id must not be null")
    @Min(value = 1, message = "id must be more than 0")
    private Long id;

    public Long getId() {
        return id;
    }
}
