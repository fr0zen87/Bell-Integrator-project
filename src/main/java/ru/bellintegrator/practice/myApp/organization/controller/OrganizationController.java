package ru.bellintegrator.practice.myApp.organization.controller;

import ru.bellintegrator.practice.myApp.organization.model.Organization;

import java.util.List;

public interface OrganizationController {

    List<String> list(Organization organization);

    Organization loadById(Long id);

    String update(Organization organization);

    String save(Organization organization);

    String delete(Organization organization);
}
