package ru.bellintegrator.practice.documents.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.documents.model.DocType;

/**
 * {@inheritDoc}
 */
public interface DocTypeDao extends JpaRepository<DocType, Long> {
}
