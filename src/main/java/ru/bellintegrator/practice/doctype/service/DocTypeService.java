package ru.bellintegrator.practice.doctype.service;

import ru.bellintegrator.practice.doctype.views.DocTypeView;

import java.util.List;
import java.util.Map;

/**
 * Service to work with DocType
 */
public interface DocTypeService {

    /**
     * @return map of all DocTypes
     */
    Map<String, List<DocTypeView>> documents();
}
