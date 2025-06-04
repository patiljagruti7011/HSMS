/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "speciality_master")
@NamedQueries({
    @NamedQuery(name = "SpecialityMaster.findAll", query = "SELECT s FROM SpecialityMaster s"),
    @NamedQuery(name = "SpecialityMaster.findById", query = "SELECT s FROM SpecialityMaster s WHERE s.id = :id"),
    @NamedQuery(name = "SpecialityMaster.findBySpeciality", query = "SELECT s FROM SpecialityMaster s WHERE s.speciality = :speciality")})
public class SpecialityMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "speciality")
    private String speciality;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialtyId")
    private Collection<DoctorsDetails> doctorsDetailsCollection;

    public SpecialityMaster() {
    }

    public SpecialityMaster(Integer id) {
        this.id = id;
    }

    public SpecialityMaster(Integer id, String speciality) {
        this.id = id;
        this.speciality = speciality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Collection<DoctorsDetails> getDoctorsDetailsCollection() {
        return doctorsDetailsCollection;
    }

    public void setDoctorsDetailsCollection(Collection<DoctorsDetails> doctorsDetailsCollection) {
        this.doctorsDetailsCollection = doctorsDetailsCollection;
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
        if (!(object instanceof SpecialityMaster)) {
            return false;
        }
        SpecialityMaster other = (SpecialityMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SpecialityMaster[ id=" + id + " ]";
    }
    
}
