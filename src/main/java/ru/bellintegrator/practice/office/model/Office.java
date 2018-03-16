package ru.bellintegrator.practice.office.model;

import ru.bellintegrator.practice.office.views.OfficeView;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.List;

/**
 * Entity class for office table
 */
@Entity
@Table(name = "office")
public class Office {

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
     * Office name
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Office address
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * Office phone
     */
    @Column(name = "phone", length = 12)
    private String phone;

    /**
     * Field to show active or inactive status of office
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Organization in which the office is attached
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    /**
     * List of users working in office
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "office",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> users;

    public Office() {
    }

    public Office(OfficeView view) {
        this.name = view.getName();
        this.address = view.getAddress();
        this.phone = view.getPhone();
        this.isActive = view.getActive();
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + (phone != null ? phone : "") + '\'' +
                ", isActive=" + (isActive != null ? isActive : "") +
                '}';
    }
}
