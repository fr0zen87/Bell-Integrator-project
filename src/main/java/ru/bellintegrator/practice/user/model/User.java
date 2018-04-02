package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.doctype.model.DocType;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.views.requests.UserSaveRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;

/**
 * Entity class for user table
 */
@Entity
@Table(name = "user")
public class User {

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
    private int version;

    /**
     * User first name
     */
    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    /**
     * User second name
     */
    @Column(name = "second_name", length = 20, nullable = false)
    private String secondName;

    /**
     * User middle name
     */
    @Column(name = "middle_name", length = 20, nullable = false)
    private String middleName;

    /**
     * User position
     */
    @Column(name = "position", nullable = false)
    private String position;

    /**
     * User phone
     */
    @Column(name = "phone", length = 12, nullable = false)
    private String phone;

    /**
     * User document type
     */
    @OneToOne
    @JoinColumn(name = "doc_type_id")
    private DocType docType;

    /**
     * User document number
     */
    @Column(name = "document_number", length = 20, nullable = false)
    private String documentNumber;

    /**
     * User document date
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "document_date", nullable = false)
    private Date documentDate;

    /**
     * User citizenship
     */
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;

    /**
     * Field to show active or inactive status of user
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     * Office in which the user is working in
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    public User() {
    }

    public User(UserSaveRequest save, DocType docType, Country country) {
        this.firstName = save.getFirstName();
        this.secondName = save.getSecondName();
        this.middleName = save.getMiddleName();
        this.position = save.getPosition();
        this.phone = save.getPhone();
        this.docType = docType;
        this.documentNumber = save.getDocNumber();
        this.documentDate = save.getDocDate();
        this.country = country;
        this.isIdentified = save.getIdentified();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
