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

    public void addRole(RoleMaster roleMaster);

    public void deleteRole(Integer id);

    public RoleMaster getRoleById(Integer Id);

    public Collection<AppointmentDetails> getAllAppointment();

    public Collection<DoctorsDetails> getAlldoctor();

    public void addDoctor(DoctorsDetails doctorsDetails);

    public void deleteDoctor(Integer id);

    public DoctorsDetails getDoctorById(Integer Id);

    public Collection<Receptionist> getAllReceptionist();

    public void addReceptionist(Receptionist receptionist);

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
