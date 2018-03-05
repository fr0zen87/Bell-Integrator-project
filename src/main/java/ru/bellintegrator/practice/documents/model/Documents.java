package ru.bellintegrator.practice.documents.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "doc_type")
public class Documents {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Version
    private Integer version;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    public Documents() {
    }

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
        return "Documents{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
