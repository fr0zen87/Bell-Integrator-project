package ru.bellintegrator.practice.documents.dao;

import ru.bellintegrator.practice.documents.model.DocType;

import java.util.List;

/**
 * {@inheritDoc}
 */
public interface DocTypeDao {

    List<DocType> docs();
}
