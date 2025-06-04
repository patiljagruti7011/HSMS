/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "patient_details")
@NamedQueries({
    @NamedQuery(name = "PatientDetails.findAll", query = "SELECT p FROM PatientDetails p"),
    @NamedQuery(name = "PatientDetails.findById", query = "SELECT p FROM PatientDetails p WHERE p.id = :id"),
    @NamedQuery(name = "PatientDetails.findByFirstName", query = "SELECT p FROM PatientDetails p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "PatientDetails.findByLastName", query = "SELECT p FROM PatientDetails p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "PatientDetails.findByDob", query = "SELECT p FROM PatientDetails p WHERE p.dob = :dob"),
    @NamedQuery(name = "PatientDetails.findByGender", query = "SELECT p FROM PatientDetails p WHERE p.gender = :gender"),
    @NamedQuery(name = "PatientDetails.findByContactNumber", query = "SELECT p FROM PatientDetails p WHERE p.contactNumber = :contactNumber")})
public class PatientDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name")
    private String firstName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name")
    private String lastName;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "gender")
    private String gender;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "contact_number")
    private int contactNumber;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<AppointmentDetails> appointmentDetailsCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<BillingDetails> billingDetailsCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<VisitDetails> visitDetailsCollection;

    public PatientDetails() {
    }

    public PatientDetails(Integer id) {
        this.id = id;
    }

    public PatientDetails(Integer id, String firstName, String lastName, Date dob, String gender, int contactNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Collection<AppointmentDetails> getAppointmentDetailsCollection() {
        return appointmentDetailsCollection;
    }

    public void setAppointmentDetailsCollection(Collection<AppointmentDetails> appointmentDetailsCollection) {
        this.appointmentDetailsCollection = appointmentDetailsCollection;
    }

    public Collection<BillingDetails> getBillingDetailsCollection() {
        return billingDetailsCollection;
    }

    public void setBillingDetailsCollection(Collection<BillingDetails> billingDetailsCollection) {
        this.billingDetailsCollection = billingDetailsCollection;
    }

    public Collection<VisitDetails> getVisitDetailsCollection() {
        return visitDetailsCollection;
    }

    public void setVisitDetailsCollection(Collection<VisitDetails> visitDetailsCollection) {
        this.visitDetailsCollection = visitDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientDetails)) {
            return false;
        }
        PatientDetails other = (PatientDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PatientDetails[ id=" + id + " ]";
    }
    
}
