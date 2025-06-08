/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "appointment_details")
@NamedQueries({
    @NamedQuery(name = "AppointmentDetails.findAll", query = "SELECT a FROM AppointmentDetails a"),
    @NamedQuery(name = "AppointmentDetails.findById", query = "SELECT a FROM AppointmentDetails a WHERE a.id = :id"),
    @NamedQuery(name = "AppointmentDetails.findByAppointmentDate", query = "SELECT a FROM AppointmentDetails a WHERE a.appointmentDate = :appointmentDate"),
    @NamedQuery(name = "AppointmentDetails.findByStatus", query = "SELECT a FROM AppointmentDetails a WHERE a.status = :status"),
    @NamedQuery(name = "AppointmentDetails.findByNotes", query = "SELECT a FROM AppointmentDetails a WHERE a.notes = :notes")})
public class AppointmentDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "appointment_date")
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "notes")
    private String notes;

    @JsonbTransient
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PatientDetails patientId;

    @JsonbTransient
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DoctorsDetails doctorId;

    public AppointmentDetails() {
    }

    public AppointmentDetails(Integer id) {
        this.id = id;
    }

    public AppointmentDetails(Integer id, Date appointmentDate, String status, String notes) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PatientDetails getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientDetails patientId) {
        this.patientId = patientId;
    }

    public DoctorsDetails getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(DoctorsDetails doctorId) {
        this.doctorId = doctorId;
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
        if (!(object instanceof AppointmentDetails)) {
            return false;
        }
        AppointmentDetails other = (AppointmentDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AppointmentDetails[ id=" + id + " ]";
    }

}
