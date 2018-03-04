package ru.bellintegrator.practice.myApp.countries.model;

import javax.persistence.*;

@Entity
public class Countries {

    @Version
    private int version;

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    public Countries() {
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
