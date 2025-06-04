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
import entity.Receptionist;
import entity.RoleMaster;
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
public interface AdminejbBeanLocal {
    public Collection<RoleMaster> getAllRole();

    public void addRole(int id, String username, String password, String role, int pid, int did);

    public void deleteRole(Integer id);

    public RoleMaster getRoleById(Integer Id);
    
    public Collection<AppointmentDetails> getAllAppointment();
    
    public Collection<DoctorsDetails> getAlldoctor();

    public void addDoctor(int id, String fname, String lname, String Qualification, int wh, int cno);

    public void deleteDoctor(Integer id);

    public DoctorsDetails getDoctorById(Integer Id);
    
    public Collection<Receptionist> getAllReceptionist();

    public void addReceptionist(int id, String fname, String lname, Date joining, String qauli, String cno, String gender);

    public void deleteReceptionist(Integer id);

    public Receptionist getReceptionistById(Integer Id);
    
    public Collection<PatientDetails> getAllPatient();

    public Collection<AvailabilityDetails> getAllAvailability();
    
    public AvailabilityDetails getAvailabilityById(Integer Id);
    
    public Collection<BillingDetails> getAllBill();
    
    public BillingDetails getBillById(Integer Id);
    
    public Collection<SpecialityMaster> getAllSpeciality();
    
    public Collection<VisitDetails> getAllVisit();
}
