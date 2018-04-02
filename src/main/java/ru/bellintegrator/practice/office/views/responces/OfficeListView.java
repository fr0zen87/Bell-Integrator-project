package ru.bellintegrator.practice.office.views.responces;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * List of offices view
 */
public class OfficeListView {

    private Long id;

    private String name;

    @JsonProperty(value = "isActive")
    private Boolean isActive;

    public OfficeListView() {
    }

    public OfficeListView(Object[] office) {
        this.id = (Long) office[0];
        this.name = (String) office[1];
        this.isActive = (Boolean) office[2];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter(value = "isActive")
    public Boolean getActive() {
        return isActive;
    }

    @JsonSetter(value = "isActive")
    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "OfficeListView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
