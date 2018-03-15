package ru.bellintegrator.practice.documents.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.documents.model.DocType;

/**
 * Dao to work with DocType
 */
public interface DocTypeDao extends JpaRepository<DocType, Long> {
}
