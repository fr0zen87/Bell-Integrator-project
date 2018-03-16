package ru.bellintegrator.practice.organization.views.responces;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import ru.bellintegrator.practice.organization.model.Organization;

/**
 * An organization view
 */
public class OrganizationView {

    private Long id;

    private String name;

    private String fullName;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    @JsonProperty(value = "isActive")
    private Boolean isActive;

    public OrganizationView() {
    }

    public OrganizationView(Organization organization) {
        this.id = organization.getId();
        this.name = organization.getName();
        this.fullName = organization.getFullName();
        this.inn = organization.getInn();
        this.kpp = organization.getKpp();
        this.address = organization.getAddress();
        this.phone = organization.getPhone();
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return "OrganizationView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
