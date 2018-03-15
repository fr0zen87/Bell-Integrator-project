package ru.bellintegrator.practice.documents.controller;

import ru.bellintegrator.practice.documents.views.DocTypeView;

import java.util.List;
import java.util.Map;

/**
 * DocType controller
 */
public interface DocTypeController {

    /**
     * @return map of all DocTypes
     */
    Map<String, List<DocTypeView>> documents();
}
