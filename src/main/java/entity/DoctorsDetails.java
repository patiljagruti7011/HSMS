/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "doctors_details")
@NamedQueries({
    @NamedQuery(name = "DoctorsDetails.findAll", query = "SELECT d FROM DoctorsDetails d"),
    @NamedQuery(name = "DoctorsDetails.findById", query = "SELECT d FROM DoctorsDetails d WHERE d.id = :id"),
    @NamedQuery(name = "DoctorsDetails.findByFirstName", query = "SELECT d FROM DoctorsDetails d WHERE d.firstName = :firstName"),
    @NamedQuery(name = "DoctorsDetails.findByLastName", query = "SELECT d FROM DoctorsDetails d WHERE d.lastName = :lastName"),
    @NamedQuery(name = "DoctorsDetails.findByQualification", query = "SELECT d FROM DoctorsDetails d WHERE d.qualification = :qualification"),
    @NamedQuery(name = "DoctorsDetails.findByWorkingHours", query = "SELECT d FROM DoctorsDetails d WHERE d.workingHours = :workingHours"),
    @NamedQuery(name = "DoctorsDetails.findByContactNumber", query = "SELECT d FROM DoctorsDetails d WHERE d.contactNumber = :contactNumber")})
public class DoctorsDetails implements Serializable {

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
    @Size(min = 1, max = 50)
    @Column(name = "qualification")
    private String qualification;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "working_hours")
    private int workingHours;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "contact_number")
    private int contactNumber;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId")
    private Collection<AppointmentDetails> appointmentDetailsCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId")
    private Collection<VisitDetails> visitDetailsCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId")
    private Collection<AvailabilityDetails> availabilityDetailsCollection;
    
    @JsonbTransient
    @JoinColumn(name = "specialty_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SpecialityMaster specialtyId;

    public DoctorsDetails() {
    }

    public DoctorsDetails(Integer id) {
        this.id = id;
    }

    public DoctorsDetails(Integer id, String firstName, String lastName, String qualification, int workingHours, int contactNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
        this.workingHours = workingHours;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
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

    public Collection<VisitDetails> getVisitDetailsCollection() {
        return visitDetailsCollection;
    }

    public void setVisitDetailsCollection(Collection<VisitDetails> visitDetailsCollection) {
        this.visitDetailsCollection = visitDetailsCollection;
    }

    public Collection<AvailabilityDetails> getAvailabilityDetailsCollection() {
        return availabilityDetailsCollection;
    }

    public void setAvailabilityDetailsCollection(Collection<AvailabilityDetails> availabilityDetailsCollection) {
        this.availabilityDetailsCollection = availabilityDetailsCollection;
    }

    public SpecialityMaster getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(SpecialityMaster specialtyId) {
        this.specialtyId = specialtyId;
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
        if (!(object instanceof DoctorsDetails)) {
            return false;
        }
        DoctorsDetails other = (DoctorsDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DoctorsDetails[ id=" + id + " ]";
    }
    
}
