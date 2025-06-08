/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.AdminClient;
import entity.AppointmentDetails;
import entity.AvailabilityDetails;
import entity.BillingDetails;
import entity.DoctorsDetails;
import entity.PatientDetails;
import entity.Receptionist;
import entity.RoleMaster;
import entity.SpecialityMaster;
import entity.VisitDetails;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Dell
 */
@Named(value = "adminManagedBean")
@SessionScoped
public class AdminManagedBean implements Serializable {

    @Inject
    private AdminClient adminclient;
    private Collection<AppointmentDetails> appointmentList;
    private Collection<AvailabilityDetails> availabilityList;
    private Collection<BillingDetails> billingList;
    private Collection<DoctorsDetails> doctorsList;
    private Collection<PatientDetails> patientList;
    private Collection<Receptionist> receptionistsList;
    private Collection<RoleMaster> roleList;
    private Collection<SpecialityMaster> specialityList;
    private Collection<VisitDetails> visitList;
    /* ============== RoleMaster =============== */
    @Inject
    private RoleMaster roleMaster;
    private List<String> roles;

    private final GenericType<Collection<AppointmentDetails>> appointmentGenericType = new GenericType<Collection<AppointmentDetails>>() {
    };
    private final GenericType<Collection<AvailabilityDetails>> availabilityGenericType = new GenericType<Collection<AvailabilityDetails>>() {
    };
    private final GenericType<Collection<BillingDetails>> billGenericType = new GenericType<Collection<BillingDetails>>() {
    };
    private final GenericType<Collection<DoctorsDetails>> doctorGenericType = new GenericType<Collection<DoctorsDetails>>() {
    };
    private final GenericType<Collection<PatientDetails>> patientGenericType = new GenericType<Collection<PatientDetails>>() {
    };
    private final GenericType<Collection<Receptionist>> receptionistGenericType = new GenericType<Collection<Receptionist>>() {
    };
    private final GenericType<Collection<RoleMaster>> roleGenericType = new GenericType<Collection<RoleMaster>>() {
    };
    private final GenericType<Collection<SpecialityMaster>> specialityGenericType = new GenericType<Collection<SpecialityMaster>>() {
    };
    private final GenericType<Collection<VisitDetails>> visitGenericType = new GenericType<Collection<VisitDetails>>() {
    };

    @PostConstruct
    public void init() {
        try {
            System.out.println("cdi.AdminManagedBean.init()");
            adminclient = new AdminClient();
//            appointmentList = adminclient.getAllAppointment(appointmentGenericType);
//            availabilityList = adminclient.getAllAvailability(availabilityGenericType);
//            billingList = adminclient.getAllBill(billGenericType);
            doctorsList = adminclient.getAlldoctor(doctorGenericType);
            patientList = adminclient.getAllPatient(patientGenericType);
//            receptionistsList = adminclient.getAllReceptionist(receptionistGenericType);
            roleList = adminclient.getAllRole(roleGenericType);
//            specialityList = adminclient.getAllSpeciality(specialityGenericType);
//            visitList = adminclient.getAllVisit(visitGenericType);

            roles = Arrays.asList("Admin", "Patient", "Doctor");
        } catch (ClientErrorException e) {
        } catch (Exception e) {
        }
    }

    private void safeLoad(Runnable task) {
        try {
            task.run();
        } catch (Exception e) {
            // Log the exception

        }
    }

    /**
     * getAllRole
     *
     * @return
     */
    public Collection<RoleMaster> getAllRole() {
        return roleList;
    }

    /**
     * Add Role
     */
    public void addRole() {
        try {
            System.out.println("Method called..");
            boolean roleExists = roleList.stream()
                    .anyMatch(role -> role.getUsername().equalsIgnoreCase(roleMaster.getUsername()));

            if (roleExists) {
                System.out.println("Username already exists.");
//                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail", "Username already exists.");
//                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                RoleMaster newRole = new RoleMaster();
                newRole.setId(roleMaster.getId());
                newRole.setUsername(roleMaster.getUsername());
                newRole.setPassword(roleMaster.getPassword());
                newRole.setRole(roleMaster.getRole());
                newRole.setPatientId(roleMaster.getPatientId());
                newRole.setDoctorId(roleMaster.getDoctorId());
                adminclient.addRole(newRole);
                roleList = adminclient.getAllRole(roleGenericType);
//                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User added: " + roleMaster.getUsername());
//                FacesContext.getCurrentInstance().addMessage(null, msg);
//                roleMaster = new RoleMaster();
                roleList = null;
            }
        } catch (ClientErrorException e) {
            System.out.println("Failed to add Role.");
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail", "Failed to add Role.");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    /**
     * Delete Role
     *
     * @param roleid
     */
    public void deleteRole(int roleid) {
        adminclient.deleteRole(roleid);
        roleList = null;
        roleList = adminclient.getAllRole(roleGenericType);
    }

    public RoleMaster getRoleMaster() {
        return roleMaster;
    }

    public void setRoleMaster(RoleMaster roleMaster) {
        this.roleMaster = roleMaster;
    }

    public List<String> getRoles() {
        return roles;
    }

    //======================== Appointment methods ==================================================
    //getAppointment
//    public Collection<AppointmentDetails> getAllAppointment() {
//        return appointmentList;
//    }
    /**
     * getAlldoctor
     *
     * @return
     */
    public Collection<DoctorsDetails> getAlldoctor() {
        return doctorsList;
    }
//
//    //Add Doctor
//    public void addDoctor() {
//        try {
//            boolean doctorExists = doctorsList.stream()
//                    .anyMatch(doctor -> doctor.getFirstName().equalsIgnoreCase(firstName));
//
//            if (doctorExists) {
//                System.out.println("doctor name already exists.");
//            }
//            DoctorsDetails newDoctor = new DoctorsDetails();
//            newDoctor.setId(did);
//            newDoctor.setFirstName(firstName);
//            newDoctor.setLastName(lastName);
//            newDoctor.setQualification(qualification);
//            newDoctor.setWorkingHours(workingHours);
//            newDoctor.setContactNumber(contactNumber);
//            adminclient.addDoctor(doctorExists);
//            doctorsList = adminclient.getAlldoctor(doctorGenericType);
//            did = 0;
//            firstName = "";
//            lastName = "";
//            qualification = "";
//            workingHours = 0;
//            contactNumber = 0;
//        } catch (ClientErrorException e) {
//            System.out.println("Failed to add Doctor.");
//        }
//    }
    //Delete Doctor
//    public void deleteDoctor(int did) {
//        adminclient.deleteDoctor(did);
//        doctorsList = adminclient.getAlldoctor(doctorGenericType);
//    }
    // Edit  Doctor
    DoctorsDetails SelectedDoctor;

//    public void editDoctor(DoctorsDetails doctorsDetails) {
//        this.SelectedDoctor = doctorsDetails;
//        this.did = doctorsDetails.getId();
//        this.firstName = doctorsDetails.getFirstName();
//        this.lastName = doctorsDetails.getLastName();
//        this.Qualification = doctorsDetails.getQualification();
//        this.workingHours = doctorsDetails.getWorkingHours();
//        this.contactNumber = doctorsDetails.getContactNumber();
//    }
    //======================== Receptionist methods ==================================================
    //get Receptionist
//    public Collection<Receptionist> getAllReceptionist() {
//        return receptionistsList;
//    }
    //Add Receptionist
//    public void addReceptionist() {
//        try {
//            boolean receptionistExists = receptionistsList.stream()
//                    .anyMatch(receptionist -> receptionist.getFirstName().equalsIgnoreCase(firstName));
//
//            if (receptionistExists) {
//                System.out.println("receptionist name already exists.");
//            }
//            Receptionist newreceptionist = new Receptionist();
//            newreceptionist.setId(rid);
//            newreceptionist.setFirstName(firstName);
//            newreceptionist.setLastName(lastName);
//            newreceptionist.setJoiningDate(joiningDate);
//            newreceptionist.setQualification(qualification);
//            newreceptionist.setContactNumber(contact_Number);
//            newreceptionist.setGender(gender);
//            adminclient.addReceptionist(receptionistExists);
//            receptionistsList = adminclient.getAllReceptionist(receptionistGenericType);
//            rid = 0;
//            firstName = "";
//            lastName = "";
//            joiningDate = null;
//            qualification = "";
//            contact_Number = null;
//            gender = "";
//        } catch (ClientErrorException e) {
//            System.out.println("Failed to add Receptionist.");
//        }
//    }
    //Delete Receptionist
//    public void deleteReceptionist(int rid) {
//        adminclient.deleteReceptionist(rid);
//        receptionistsList = adminclient.getAllReceptionist(receptionistGenericType);
//    }
    // Edit  Receptionist
//    Receptionist SelectedReceptionist;
//
//    public void editReceptionist(Receptionist receptionist) {
//        this.SelectedReceptionist = receptionist;
//        this.rid = receptionist.getId();
//        this.firstName = receptionist.getFirstName();
//        this.lastName = receptionist.getLastName();
//        this.joiningDate = receptionist.getJoiningDate();
//        this.Qualification = receptionist.getQualification();
//        this.contact_Number = receptionist.getContactNumber();
//        this.Gender = receptionist.getGender();
//    }
    /**
     * getAllPatient
     *
     * @return
     */
    public Collection<PatientDetails> getAllPatient() {
        return patientList;
    }

    //======================== Availability methods ==================================================
    //get Availability
//    public Collection<AvailabilityDetails> getAllAvailability() {
//        return availabilityList;
//    }
    //======================== Bill methods ==================================================
    //get Bill
//    public Collection<BillingDetails> getAllBill() {
//        return billingList;
//    }
//
//    public Response getBillById(int billId) {
//        return adminclient.getBillById(billId);
//    }
    //======================== Speciality methods ==================================================
    //get Speciality
//    public Collection<SpecialityMaster> getAllSpeciality() {
//        return specialityList;
//    }
    //======================== Visit methods ==================================================
    //get Visit
//    public Collection<VisitDetails> getAllVisit() {
//        return visitList;
//    }
    /**
     * Creates a new instance of AdminManagedBean
     */
    public AdminManagedBean() {
        System.out.println("Call coming");
    }

}
