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

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "availability_details")
@NamedQueries({
    @NamedQuery(name = "AvailabilityDetails.findAll", query = "SELECT a FROM AvailabilityDetails a"),
    @NamedQuery(name = "AvailabilityDetails.findById", query = "SELECT a FROM AvailabilityDetails a WHERE a.id = :id"),
    @NamedQuery(name = "AvailabilityDetails.findByDayOfWeek", query = "SELECT a FROM AvailabilityDetails a WHERE a.dayOfWeek = :dayOfWeek"),
    @NamedQuery(name = "AvailabilityDetails.findByStartTime", query = "SELECT a FROM AvailabilityDetails a WHERE a.startTime = :startTime"),
    @NamedQuery(name = "AvailabilityDetails.findByEndTime", query = "SELECT a FROM AvailabilityDetails a WHERE a.endTime = :endTime")})
public class AvailabilityDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "day_of_week")
    private int dayOfWeek;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    
    @JsonbTransient
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DoctorsDetails doctorId;
    
    public AvailabilityDetails() {
    }

    public AvailabilityDetails(Integer id) {
        this.id = id;
    }

    public AvailabilityDetails(Integer id, int dayOfWeek, Date startTime, Date endTime) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        if (!(object instanceof AvailabilityDetails)) {
            return false;
        }
        AvailabilityDetails other = (AvailabilityDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AvailabilityDetails[ id=" + id + " ]";
    }
    
}
