package ru.bellintegrator.practice.countries.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Entity class for country table
 */
@Entity
@Table(name = "country")
public class Country {

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
     * Country name
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Country code
     */
    @Column(name = "code", length = 3, nullable = false)
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
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
