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
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface PatientejbBeanLocal {
    
    public AppointmentDetails getAppointmentById(Integer Id);
    
    public Collection<DoctorsDetails> getAlldoctor();
    
    public Collection<AvailabilityDetails> getAllAvailability();
    
    public AvailabilityDetails getAvailabilityById(Integer Id);
    
    public BillingDetails getBillById(Integer Id);

    public PatientDetails getPatientById(Integer id);
}
