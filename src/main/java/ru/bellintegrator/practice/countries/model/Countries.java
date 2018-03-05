package ru.bellintegrator.practice.countries.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "country")
public class Countries {

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

    public Countries() {
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
        return "Countries{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
