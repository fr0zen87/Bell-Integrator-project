package ru.bellintegrator.practice.doctype.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Entity class for doc_type table
 */
@Entity
@Table(name = "doc_type")
public class DocType {

    /**
     * Primary key
     */
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    /**
     * Hibernate specified field
     */
    @Version
    private Integer version;

    /**
     * DocType name
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * DocType code
     */
    @Column(name = "code", length = 2, nullable = false)
    private String code;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DocType{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
