package ru.bellintegrator.practice.myApp.organization.service;

import ru.bellintegrator.practice.myApp.organization.model.Organization;

import java.util.List;

public interface OrganizationService {

    List<String> list(String name, String inn, boolean isActive);

    Organization loadById(Long id);

    String update(Organization organization);

    String save(Organization organization);

    String delete(Long id);
}
