package ru.bellintegrator.practice.office.views.requests;

import java.util.HashMap;
import java.util.Map;

public class OfficeFilterHelper {

    public static Map<String, Object> getFilters(OfficeFilter filter) {
        Map<String, Object> filters = new HashMap<>();

        if (filter.getOrgId() != null) {
            filters.put("organization", filter.getOrgId());
        } else {
            throw new NullPointerException("orgId is required");
        }
        if (filter.getName() != null) {
            filters.put("name", filter.getName());
        }
        if (filter.getPhone() != null) {
            filters.put("phone", filter.getPhone());
        }
        if (filter.getActive() != null) {
            filters.put("isActive", filter.getActive());
        }
        return filters;
    }
}
