package ru.bellintegrator.practice.organization.model;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.views.requests.OrganizationSaveRequest;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.List;

/**
 * Entity class for organization table
 */
@Entity
@Table(name = "organization")
public class Organization {

    /**
     * Primary key
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * Hibernate specified field
     */
    @Version
    private Integer version;

    /**
     * Organization short name
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Organization full name
     */
    @Column(name = "full_name", nullable = false, unique = true)
    private String fullName;

    /**
     * Organization INN
     */
    @Column(name = "inn", length = 12, nullable = false)
    private String inn;

    /**
     * Organization KPP
     */
    @Column(name = "kpp", length = 9, nullable = false)
    private String kpp;

    /**
     * Organization address
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * Organization phone
     */
    @Column(name = "phone", length = 12)
    private String phone;

    /**
     * Field to show active or inactive status of organization
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * List of all offices in an organization
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Office> offices;

    public Organization() {
    }

    public Organization(OrganizationSaveRequest save) {
        this.name = save.getName();
        this.fullName = save.getFullName();
        this.inn = save.getInn();
        this.kpp = save.getKpp();
        this.address = save.getAddress();
        this.phone = save.getPhone();
        this.isActive = save.getActive();
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public void addOffice(Office office) {
        getOffices().add(office);
        office.setOrganization(this);
    }

    public void removeOffice(Office office) {
        getOffices().remove(office);
        office.setOrganization(null);
    }
}
