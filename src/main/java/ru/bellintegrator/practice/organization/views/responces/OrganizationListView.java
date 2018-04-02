package ru.bellintegrator.practice.organization.views.responces;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import ru.bellintegrator.practice.organization.model.Organization;

/**
 * List of organizations view
 */
public class OrganizationListView {

    private Long id;

    private String name;

    @JsonProperty(value = "isActive")
    private Boolean isActive;

    public OrganizationListView() {
    }

    public OrganizationListView(Organization organization) {
        this.id = organization.getId();
        this.name = organization.getName();
        this.isActive = organization.isActive();
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
        return "OrganizationListView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
