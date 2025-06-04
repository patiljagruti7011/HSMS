/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "visit_details")
@NamedQueries({
    @NamedQuery(name = "VisitDetails.findAll", query = "SELECT v FROM VisitDetails v"),
    @NamedQuery(name = "VisitDetails.findById", query = "SELECT v FROM VisitDetails v WHERE v.id = :id"),
    @NamedQuery(name = "VisitDetails.findByVisitDate", query = "SELECT v FROM VisitDetails v WHERE v.visitDate = :visitDate"),
    @NamedQuery(name = "VisitDetails.findByVisitCharge", query = "SELECT v FROM VisitDetails v WHERE v.visitCharge = :visitCharge")})
public class VisitDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "visit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "visit_charge")
    private double visitCharge;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitId")
    private Collection<BillingDetails> billingDetailsCollection;
    
    @JsonbTransient
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DoctorsDetails doctorId;
    
    @JsonbTransient
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PatientDetails patientId;

    public VisitDetails() {
    }

    public VisitDetails(Integer id) {
        this.id = id;
    }

    public VisitDetails(Integer id, Date visitDate, double visitCharge) {
        this.id = id;
        this.visitDate = visitDate;
        this.visitCharge = visitCharge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public double getVisitCharge() {
        return visitCharge;
    }

    public void setVisitCharge(double visitCharge) {
        this.visitCharge = visitCharge;
    }

    public Collection<BillingDetails> getBillingDetailsCollection() {
        return billingDetailsCollection;
    }

    public void setBillingDetailsCollection(Collection<BillingDetails> billingDetailsCollection) {
        this.billingDetailsCollection = billingDetailsCollection;
    }

    public DoctorsDetails getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(DoctorsDetails doctorId) {
        this.doctorId = doctorId;
    }

    public PatientDetails getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientDetails patientId) {
        this.patientId = patientId;
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
        if (!(object instanceof VisitDetails)) {
            return false;
        }
        VisitDetails other = (VisitDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VisitDetails[ id=" + id + " ]";
    }
    
}
