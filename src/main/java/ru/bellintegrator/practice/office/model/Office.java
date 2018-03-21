package ru.bellintegrator.practice.office.model;

import ru.bellintegrator.practice.office.views.requests.OfficeSaveRequest;
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

    public Office(OfficeSaveRequest save) {
        this.name = save.getName();
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        getUsers().add(user);
        user.setOffice(this);
    }

    public void removeUser(User user) {
        getUsers().remove(user);
        user.setOffice(null);
    }
}
