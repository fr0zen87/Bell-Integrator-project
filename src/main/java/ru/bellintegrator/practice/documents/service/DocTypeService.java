package ru.bellintegrator.practice.documents.service;

import ru.bellintegrator.practice.documents.views.DocTypeView;

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
