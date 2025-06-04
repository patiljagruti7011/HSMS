/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "medicine_details")
@NamedQueries({
    @NamedQuery(name = "MedicineDetails.findAll", query = "SELECT m FROM MedicineDetails m"),
    @NamedQuery(name = "MedicineDetails.findById", query = "SELECT m FROM MedicineDetails m WHERE m.id = :id"),
    @NamedQuery(name = "MedicineDetails.findByMedicineName", query = "SELECT m FROM MedicineDetails m WHERE m.medicineName = :medicineName"),
    @NamedQuery(name = "MedicineDetails.findByQuantity", query = "SELECT m FROM MedicineDetails m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "MedicineDetails.findByExpirationDate", query = "SELECT m FROM MedicineDetails m WHERE m.expirationDate = :expirationDate")})
public class MedicineDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "medicine_name")
    private String medicineName;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    
    @OneToMany(mappedBy = "medicineId")
    private Collection<BillingDetails> billingDetailsCollection;

    public MedicineDetails() {
    }

    public MedicineDetails(Integer id) {
        this.id = id;
    }

    public MedicineDetails(Integer id, String medicineName, int quantity, Date expirationDate) {
        this.id = id;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Collection<BillingDetails> getBillingDetailsCollection() {
        return billingDetailsCollection;
    }

    public void setBillingDetailsCollection(Collection<BillingDetails> billingDetailsCollection) {
        this.billingDetailsCollection = billingDetailsCollection;
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
        if (!(object instanceof MedicineDetails)) {
            return false;
        }
        MedicineDetails other = (MedicineDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MedicineDetails[ id=" + id + " ]";
    }
    
}
