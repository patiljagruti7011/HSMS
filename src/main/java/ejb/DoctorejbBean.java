/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.AppointmentDetails;
import entity.AvailabilityDetails;
import entity.DoctorsDetails;
import entity.PatientDetails;
import entity.ReportType;
import entity.SpecialityMaster;
import entity.VisitDetails;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dell
 */
@Stateless
public class DoctorejbBean implements DoctorejbBeanLocal {

    @PersistenceContext(unitName = "hsmspu")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Collection<AppointmentDetails> getAllAppointment() {
        return em.createNamedQuery("AppointmentDetails.findAll", AppointmentDetails.class).getResultList();
    }

    
    //DoctorDetail
    @Override
    public Collection<DoctorsDetails> getAlldoctor() {
        return em.createNamedQuery("DoctorsDetails.findAll", DoctorsDetails.class).getResultList();
    }

    
    @Override
    public DoctorsDetails getDoctorById(Integer Id) {
        return em.createNamedQuery("DoctorsDetails.findById", DoctorsDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }

    @Override
    public Collection<PatientDetails> getAllPatient() {
        return em.createNamedQuery("PatientDetails.findAll", PatientDetails.class).getResultList();
    }
  
    @Override
    public PatientDetails getPatientById(Integer Id) {
        return em.createNamedQuery("PatientDetails.findById", PatientDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }

    @Override
    public Collection<AvailabilityDetails> getAllAvailability() {
        return em.createNamedQuery("AvailabilityDetails.findAll", AvailabilityDetails.class).getResultList();
    }

    @Override
    public void addAvailability(int id, int dayofweek, Date stime, Date etime, DoctorsDetails did) {
        AvailabilityDetails a = new AvailabilityDetails();
        a.setId(id);
        a.setDayOfWeek(dayofweek);
        a.setStartTime(stime);
        a.setEndTime(etime);
        a.setDoctorId(did);
        em.persist(a);
    }

    @Override
    public void deleteAvailability(Integer id) {
        AvailabilityDetails av = (AvailabilityDetails) em.find(AvailabilityDetails.class, id);
        em.remove(av);
    }
    
    @Override
    public AvailabilityDetails getAvailabilityById(Integer Id) {
        return em.createNamedQuery("AvailabilityDetails.findById", AvailabilityDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }

    @Override
    public Collection<ReportType> getAllReport() {
        return em.createNamedQuery("ReportType.findAll", ReportType.class).getResultList();
    }

    @Override
    public void addReport(Integer id, String reportName) {
        ReportType rt = new ReportType();
        rt.setId(id);
        rt.setReportName(reportName);
        em.persist(rt);
    }

    @Override
    public void deleteReport(Integer id) {
        ReportType r = (ReportType) em.find(ReportType.class, id);
        em.remove(r);
    }
    
    @Override
    public ReportType getReportById(Integer Id) {
        return em.createNamedQuery("ReportType.findById", ReportType.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }

    @Override
    public Collection<SpecialityMaster> getAllSpeciality() {
        return em.createNamedQuery("SpecialityMaster.findAll", SpecialityMaster.class).getResultList();
    }

    @Override
    public void addSpeciality(Integer id, String speciality) {
        SpecialityMaster s = new SpecialityMaster();
        s.setId(id);
        s.setSpeciality(speciality);
        em.persist(s);
    }

    @Override
    public void deleteSpeciality(Integer id) {
        SpecialityMaster s = (SpecialityMaster) em.find(SpecialityMaster.class, id);
        em.remove(s);
    }
    
     @Override
    public SpecialityMaster getSpecialityById(Integer Id) {
        return em.createNamedQuery("SpecialityMaster.findById", SpecialityMaster.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }
   

    @Override
    public Collection<VisitDetails> getAllVisit() {
        return em.createNamedQuery("VisitDetails.findAll", VisitDetails.class).getResultList();
    }

    @Override
    public VisitDetails getvisitById(Integer Id) {
        return em.createNamedQuery("VisitDetails.findById", VisitDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }
}
