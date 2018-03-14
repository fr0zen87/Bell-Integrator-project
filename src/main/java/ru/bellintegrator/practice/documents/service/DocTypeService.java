package ru.bellintegrator.practice.documents.service;

import ru.bellintegrator.practice.documents.views.DocTypeView;

import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}
 */
public interface DocTypeService {

    Map<String, List<DocTypeView>> documents();
}
