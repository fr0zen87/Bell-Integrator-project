package ru.bellintegrator.practice.user.views.requests;

import java.util.HashMap;
import java.util.Map;

public class UserFilterHelper {

    public static Map<String, Object> getFilters(UserFilter filter) {
        Map<String, Object> filters = new HashMap<>();

        if (filter.getOfficeId() != null) {
            filters.put("office", filter.getOfficeId());
        }
        if (filter.getFirstName() != null) {
            filters.put("firstName", filter.getFirstName());
        }
        if (filter.getSecondName() != null) {
            filters.put("secondName", filter.getSecondName());
        }
        if (filter.getMiddleName() != null) {
            filters.put("middleName", filter.getMiddleName());
        }
        if (filter.getPosition() != null) {
            filters.put("position", filter.getPosition());
        }
        if (filter.getCitizenshipCode() != null) {
            filters.put("citizenshipCode", filter.getCitizenshipCode());
        }
        if (filter.getDocCode() != null) {
            filters.put("docCode", filter.getDocCode());
        }
        return filters;
    }
}
