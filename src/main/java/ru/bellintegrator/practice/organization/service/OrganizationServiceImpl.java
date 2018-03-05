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
    public List<Organization> list(String name, String inn, boolean isActive) {
        List<Organization> list = dao.list(name, inn, isActive);
        log.debug(list.toString());
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public Organization loadById(Long id) {
        Organization organization = dao.loadById(id);
        if (organization != null) {
            log.debug(organization.toString());
        }
        return organization;
    }

    @Override
    @Transactional
    public String update(Organization organization) {
        String result = dao.update(organization);
        log.debug(result);
        return result;
    }

    @Override
    @Transactional
    public String save(Organization organization) {
        String result = dao.save(organization);
        log.debug(result);
        return result;
    }

    @Override
    @Transactional
    public String delete(Long id) {
        String result = dao.delete(id);
        log.debug(result);
        return result;
    }
}
