/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
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
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface DoctorejbBeanLocal {
    public Collection<AppointmentDetails> getAllAppointment();
    
    public Collection<DoctorsDetails> getAlldoctor();
    
    public DoctorsDetails getDoctorById(Integer Id);
    
    public Collection<PatientDetails> getAllPatient();
    
    public PatientDetails getPatientById(Integer Id);
    
    public Collection<AvailabilityDetails> getAllAvailability();

    public void addAvailability(int id, int dayofweek, Date stime, Date etime, DoctorsDetails did);

    public void deleteAvailability(Integer id);

    public AvailabilityDetails getAvailabilityById(Integer Id);
    
    public Collection<ReportType> getAllReport();

    public void addReport(Integer id, String reportName);

    public void deleteReport(Integer id);

    public ReportType getReportById(Integer Id);
    
    public Collection<SpecialityMaster> getAllSpeciality();

    public void addSpeciality(Integer id, String speciality);

    public void deleteSpeciality(Integer id);

    public SpecialityMaster getSpecialityById(Integer Id);
    
    public Collection<VisitDetails> getAllVisit();
    
    public VisitDetails getvisitById(Integer Id);

}
