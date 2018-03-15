package ru.bellintegrator.practice.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.views.ResponseView;
import ru.bellintegrator.practice.organization.views.OrganizationView;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {

    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDao dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseView> list(OrganizationView view) {
        List<ResponseView> organizationViews = new ArrayList<>();
        dao.list(view).forEach(organization -> {
            ResponseView organizationView = new ResponseView();
            organizationView.setId(organization.getId());
            organizationView.setName(organization.getName());
            organizationView.setActive(organization.isActive());
            log.debug(organizationView.toString());
            organizationViews.add(organizationView);
        });
        return organizationViews;
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationView loadById(Long id) {
        OrganizationView view = new OrganizationView(dao.loadById(id));
        log.debug(view.toString());
        return view;
    }

    @Override
    @Transactional
    public void update(OrganizationView view) {
        dao.update(view);
    }

    @Override
    @Transactional
    public void save(OrganizationView view) {
        dao.save(view);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }
}
