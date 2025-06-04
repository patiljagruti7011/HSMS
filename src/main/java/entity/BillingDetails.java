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
@Table(name = "billing_details")
@NamedQueries({
    @NamedQuery(name = "BillingDetails.findAll", query = "SELECT b FROM BillingDetails b"),
    @NamedQuery(name = "BillingDetails.findById", query = "SELECT b FROM BillingDetails b WHERE b.id = :id"),
    @NamedQuery(name = "BillingDetails.findByBillAmount", query = "SELECT b FROM BillingDetails b WHERE b.billAmount = :billAmount"),
    @NamedQuery(name = "BillingDetails.findByBillingDate", query = "SELECT b FROM BillingDetails b WHERE b.billingDate = :billingDate"),
    @NamedQuery(name = "BillingDetails.findByPaymentStatus", query = "SELECT b FROM BillingDetails b WHERE b.paymentStatus = :paymentStatus")})
public class BillingDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "bill_amount")
    private double billAmount;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "billing_date")
    @Temporal(TemporalType.DATE)
    private Date billingDate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "payment_status")
    private String paymentStatus;
    
    @JsonbTransient
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PatientDetails patientId;
    
    @JsonbTransient
    @JoinColumn(name = "visit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VisitDetails visitId;
    
    @JsonbTransient
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    @ManyToOne
    private MedicineDetails medicineId;

    public BillingDetails() {
    }

    public BillingDetails(Integer id) {
        this.id = id;
    }

    public BillingDetails(Integer id, double billAmount, Date billingDate, String paymentStatus) {
        this.id = id;
        this.billAmount = billAmount;
        this.billingDate = billingDate;
        this.paymentStatus = paymentStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PatientDetails getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientDetails patientId) {
        this.patientId = patientId;
    }

    public VisitDetails getVisitId() {
        return visitId;
    }

    public void setVisitId(VisitDetails visitId) {
        this.visitId = visitId;
    }

    public MedicineDetails getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(MedicineDetails medicineId) {
        this.medicineId = medicineId;
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
        if (!(object instanceof BillingDetails)) {
            return false;
        }
        BillingDetails other = (BillingDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BillingDetails[ id=" + id + " ]";
    }
    
}
