/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.AppointmentDetails;
import entity.AvailabilityDetails;
import entity.BillingDetails;
import entity.DoctorsDetails;
import entity.PatientDetails;
import entity.VisitDetails;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface ReceptionistejbBeanLocal {
    public Collection<AppointmentDetails> getAllAppointment();

    public void addAppointment(int id, Date apDate, String status, String notes, PatientDetails pid, DoctorsDetails did);

    public void deleteAppointment(Integer id);

    public AppointmentDetails getAppointmentById(Integer Id);

    public Collection<DoctorsDetails> getAlldoctor();
    
    public Collection<PatientDetails> getAllPatient();

    public void addPatient(Integer id, String firstName, String lastName, Date dob, String gender, int contactNumber);

    public void deletePatient(Integer id);

    public PatientDetails getPatientById(Integer Id);
   
    public Collection<AvailabilityDetails> getAllAvailability();
    
    public AvailabilityDetails getAvailabilityById(Integer Id);
    
    public Collection<BillingDetails> getAllBill();

    public void addBill(Integer id, double billAmount, Date billingDate, String paymentStatus);

    public void deleteBill(Integer id);

    public BillingDetails getBillById(Integer Id);
    
    public Collection<VisitDetails> getAllVisit();

    public void addVisit(Integer id, Date visitDate, double visitCharge);

    public void deleteVisit(Integer id);

    public VisitDetails getvisitById(Integer Id);

}
