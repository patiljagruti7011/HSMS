/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "role_master")
@NamedQueries({
    @NamedQuery(name = "RoleMaster.findAll", query = "SELECT r FROM RoleMaster r"),
    @NamedQuery(name = "RoleMaster.findById", query = "SELECT r FROM RoleMaster r WHERE r.id = :id"),
    @NamedQuery(name = "RoleMaster.findByUsername", query = "SELECT r FROM RoleMaster r WHERE r.username = :username"),
    @NamedQuery(name = "RoleMaster.findByPassword", query = "SELECT r FROM RoleMaster r WHERE r.password = :password"),
    @NamedQuery(name = "RoleMaster.findByRole", query = "SELECT r FROM RoleMaster r WHERE r.role = :role"),
    @NamedQuery(name = "RoleMaster.findByPatientId", query = "SELECT r FROM RoleMaster r WHERE r.patientId = :patientId"),
    @NamedQuery(name = "RoleMaster.findByDoctorId", query = "SELECT r FROM RoleMaster r WHERE r.doctorId = :doctorId")})
public class RoleMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "role")
    private String role;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "patient_id")
    private int patientId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "doctor_id")
    private int doctorId;

    public RoleMaster() {
    }

    public RoleMaster(Integer id) {
        this.id = id;
    }

    public RoleMaster(Integer id, String username, String password, String role, int patientId, int doctorId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
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
        if (!(object instanceof RoleMaster)) {
            return false;
        }
        RoleMaster other = (RoleMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RoleMaster[ id=" + id + " ]";
    }
    
}
