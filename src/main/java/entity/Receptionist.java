/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "receptionist")
@NamedQueries({
    @NamedQuery(name = "Receptionist.findAll", query = "SELECT r FROM Receptionist r"),
    @NamedQuery(name = "Receptionist.findById", query = "SELECT r FROM Receptionist r WHERE r.id = :id"),
    @NamedQuery(name = "Receptionist.findByFirstName", query = "SELECT r FROM Receptionist r WHERE r.firstName = :firstName"),
    @NamedQuery(name = "Receptionist.findByLastName", query = "SELECT r FROM Receptionist r WHERE r.lastName = :lastName"),
    @NamedQuery(name = "Receptionist.findByJoiningDate", query = "SELECT r FROM Receptionist r WHERE r.joiningDate = :joiningDate"),
    @NamedQuery(name = "Receptionist.findByQualification", query = "SELECT r FROM Receptionist r WHERE r.qualification = :qualification"),
    @NamedQuery(name = "Receptionist.findByContactNumber", query = "SELECT r FROM Receptionist r WHERE r.contactNumber = :contactNumber"),
    @NamedQuery(name = "Receptionist.findByGender", query = "SELECT r FROM Receptionist r WHERE r.gender = :gender")})
public class Receptionist implements Serializable {

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
    @Column(name = "joining_date")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "qualification")
    private String qualification;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "contact_number")
    private String contactNumber;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "gender")
    private String gender;

    public Receptionist() {
    }

    public Receptionist(Integer id) {
        this.id = id;
    }

    public Receptionist(Integer id, String firstName, String lastName, Date joiningDate, String qualification, String contactNumber, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.contactNumber = contactNumber;
        this.gender = gender;
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

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        if (!(object instanceof Receptionist)) {
            return false;
        }
        Receptionist other = (Receptionist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Receptionist[ id=" + id + " ]";
    }
    
}
