package ru.bellintegrator.practice.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.dao.OrganizationDAO;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.model.OrganizationView;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {

    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDAO dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> list(String name, String inn, boolean isActive) {
        List<Organization> list = dao.list(name, inn, isActive);
        List<OrganizationView> result = new ArrayList<>();
        list.forEach(organization -> {
            OrganizationView view = new OrganizationView();
            view.setId(organization.getId());
            view.setName(organization.getName());
            view.setActive(organization.isActive());
            log.debug(view.toString());
            result.add(view);
        });
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Organization loadById(Long id) {
        Organization result = dao.loadById(id);
        log.debug(result.toString());
        return result;
    }

    @Override
    @Transactional
    public Organization update(Organization organization) {
        Organization result = dao.update(organization);
        log.debug(result.toString());
        return result;
    }

    @Override
    @Transactional
    public void save(Organization organization) {
        dao.save(organization);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }
}
