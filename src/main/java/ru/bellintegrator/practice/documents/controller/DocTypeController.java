package ru.bellintegrator.practice.documents.controller;

import ru.bellintegrator.practice.documents.views.DocTypeView;

import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}
 */
public interface DocTypeController {

    Map<String, List<DocTypeView>> documents();
}
