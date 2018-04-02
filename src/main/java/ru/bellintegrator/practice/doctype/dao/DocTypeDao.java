package ru.bellintegrator.practice.doctype.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.doctype.model.DocType;

/**
 * Dao to work with DocType
 */
public interface DocTypeDao extends JpaRepository<DocType, Long> {
}
