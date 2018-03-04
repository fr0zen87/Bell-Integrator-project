package ru.bellintegrator.practice.myApp.organization.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.myApp.organization.dao.OrganizationDAO;
import ru.bellintegrator.practice.myApp.organization.model.Organization;

import java.util.*;

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
    public List<String> list(String name, String inn, boolean isActive) {
        List<Organization> list = dao.list(name, inn, isActive);
        List<String> result = new ArrayList<>();
        log.info(list.toString());
        for (Organization o : list) {
            try {
                Organization org = new Organization(o.getId(), o.getName(), o.isActive());
                ObjectMapper mapper = new ObjectMapper();
                SimpleFilterProvider filterProvider = new SimpleFilterProvider();
                filterProvider.addFilter("filter",
                        SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "isActive"));
                mapper.setFilterProvider(filterProvider);
                String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(org);
                log.info(jsonString);
                result.add(jsonString);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    @Transactional
    public Organization loadById(Long id) {
        Organization organization = dao.loadById(id);
        if (organization != null) {
            log.info(organization.toString());
        }
        return organization;
    }

    @Override
    @Transactional
    public String update(Organization organization) {
        String result = dao.update(organization);
        log.info(result);
        return result;
    }

    @Override
    @Transactional
    public String save(Organization organization) {
        String result = dao.save(organization);
        log.info(result);
        return result;
    }

    @Override
    @Transactional
    public String delete(Long id) {
        String result = dao.delete(id);
        log.info(result);
        return result;
    }
}
