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
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dell
 */
@Named(value = "adminManagedBean")
@SessionScoped
public class AdminManagedBean implements Serializable {

//    @Inject    
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

    //============== AppointmentDetails ===============
    private Integer id;
    private Date appointmentDate;
    private String status;
    private String notes;
    private Integer patientId;
    private Integer doctorId;

    //============== AvailabilityDetails ===============
    private Integer aid;
    private int dayOfWeek;
    private Date startTime;
    private Date endTime;
    private Integer dId;

    //============== BillingDetails ===============
    private Integer bid;
    private double billAmount;
    private Date billingDate;
    private String paymentStatus;
    private Integer pId;
    private Integer visitId;
    private Integer medicineId;

    //============== DoctorsDetails ===============
    private Integer did;
    private String firstName;
    private String lastName;
    private String qualification;
    private int workingHours;
    private int contactNumber;

    //============== PatientDetails ===============
    private Integer pid;
    private String fName;
    private String lName;
    private Date dob;
    private String gender;
    private int cont_Number;
    private Collection<AppointmentDetails> appointmentDetailsCollection;
    private Collection<BillingDetails> billingDetailsCollection;
    private Collection<VisitDetails> visitDetailsCollection;

    //============== Receptionist ===============
    private Integer rid;
    private String first_Name;
    private String last_Name;
    private Date joiningDate;
    private String Qualification;
    private String contact_Number;
    private String Gender;

    //============== RoleMaster ===============
    private Integer roleid;
    private String username;
    private String password;
    private String role;
    private int patient_Id;
    private int doctor_Id;

    //============== SpecialityMaster ===============
    private Integer sid;
    private String speciality;

    //============== VisitDetails ===============
    private Integer vid;
    private Date visitDate;
    private double visitCharge;
    private Integer docId;
    private Integer patId;

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
            adminclient = new AdminClient();
            appointmentList = adminclient.getAllAppointment(appointmentGenericType);
            availabilityList = adminclient.getAllAvailability(availabilityGenericType);
            billingList = adminclient.getAllBill(billGenericType);
            doctorsList = adminclient.getAlldoctor(doctorGenericType);
            patientList = adminclient.getAllPatient(patientGenericType);
            receptionistsList = adminclient.getAllReceptionist(receptionistGenericType);
            roleList = adminclient.getAllRole(roleGenericType);
            specialityList = adminclient.getAllSpeciality(specialityGenericType);
            visitList = adminclient.getAllVisit(visitGenericType);

        } catch (ClientErrorException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void safeLoad(Runnable task) {
        try {
            task.run();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
    }

    //======================== Role methods ==================================================
    //getRole
    public Collection<RoleMaster> getAllRole() {
        return roleList;
    }

    //Add Role
    public void addRole() {
        try {
            boolean roleExists = roleList.stream()
                    .anyMatch(role -> role.getUsername().equalsIgnoreCase(username));

            if (roleExists) {
                System.out.println("Role name already exists.");
            }
            RoleMaster newRole = new RoleMaster();
            newRole.setId(roleid);
            newRole.setUsername(username);
            newRole.setPassword(password);
            newRole.setRole(role);
            newRole.setPatientId(patient_Id);
            newRole.setDoctorId(doctor_Id);
            adminclient.addRole(roleExists);
            roleList = adminclient.getAllRole(roleGenericType);
            roleid = 0;
            username = "";
            password = "";
            role = "";
            patient_Id = 0;
            doctor_Id = 0;
        } catch (ClientErrorException e) {
            System.out.println("Failed to add Role.");
        }

    }

    //Delete Role
    public void deleteRole(int roleid) {
        adminclient.deleteRole(roleid);
        roleList = adminclient.getAllRole(roleGenericType);
    }

    // Edit  Role
    RoleMaster SelectedRole;

    public void editRole(RoleMaster roleMaster) {
        this.SelectedRole = roleMaster;
        this.roleid = roleMaster.getId();
        this.username = roleMaster.getUsername();
        this.password = roleMaster.getPassword();
        this.role = roleMaster.getRole();
        this.patient_Id = roleMaster.getPatientId();
        this.doctor_Id = roleMaster.getDoctorId();
    }

    //======================== Appointment methods ==================================================
    //getAppointment
    public Collection<AppointmentDetails> getAllAppointment() {
        return appointmentList;
    }

    //======================== Doctor methods ==================================================
    //getDoctor
    public Collection<DoctorsDetails> getAlldoctor() {
        return doctorsList;
    }

    //Add Doctor
    public void addDoctor() {
        try {
            boolean doctorExists = doctorsList.stream()
                    .anyMatch(doctor -> doctor.getFirstName().equalsIgnoreCase(firstName));

            if (doctorExists) {
                System.out.println("doctor name already exists.");
            }
            DoctorsDetails newDoctor = new DoctorsDetails();
            newDoctor.setId(did);
            newDoctor.setFirstName(firstName);
            newDoctor.setLastName(lastName);
            newDoctor.setQualification(qualification);
            newDoctor.setWorkingHours(workingHours);
            newDoctor.setContactNumber(contactNumber);
            adminclient.addDoctor(doctorExists);
            doctorsList = adminclient.getAlldoctor(doctorGenericType);
            did = 0;
            firstName = "";
            lastName = "";
            qualification = "";
            workingHours = 0;
            contactNumber = 0;
        } catch (ClientErrorException e) {
            System.out.println("Failed to add Doctor.");
        }
    }

    //Delete Doctor
    public void deleteDoctor(int did) {
        adminclient.deleteDoctor(did);
        doctorsList = adminclient.getAlldoctor(doctorGenericType);
    }

    // Edit  Doctor
    DoctorsDetails SelectedDoctor;

    public void editDoctor(DoctorsDetails doctorsDetails) {
        this.SelectedDoctor = doctorsDetails;
        this.did = doctorsDetails.getId();
        this.firstName = doctorsDetails.getFirstName();
        this.lastName = doctorsDetails.getLastName();
        this.Qualification = doctorsDetails.getQualification();
        this.workingHours = doctorsDetails.getWorkingHours();
        this.contactNumber = doctorsDetails.getContactNumber();
    }

    //======================== Receptionist methods ==================================================
    //get Receptionist
    public Collection<Receptionist> getAllReceptionist() {
        return receptionistsList;
    }

    //Add Receptionist
    public void addReceptionist() {
        try {
            boolean receptionistExists = receptionistsList.stream()
                    .anyMatch(receptionist -> receptionist.getFirstName().equalsIgnoreCase(firstName));

            if (receptionistExists) {
                System.out.println("receptionist name already exists.");
            }
            Receptionist newreceptionist = new Receptionist();
            newreceptionist.setId(rid);
            newreceptionist.setFirstName(firstName);
            newreceptionist.setLastName(lastName);
            newreceptionist.setJoiningDate(joiningDate);
            newreceptionist.setQualification(qualification);
            newreceptionist.setContactNumber(contact_Number);
            newreceptionist.setGender(gender);
            adminclient.addReceptionist(receptionistExists);
            receptionistsList = adminclient.getAllReceptionist(receptionistGenericType);
            rid = 0;
            firstName = "";
            lastName = "";
            joiningDate = null;
            qualification = "";
            contact_Number = null;
            gender = "";
        } catch (ClientErrorException e) {
            System.out.println("Failed to add Receptionist.");
        }
    }

    //Delete Receptionist
    public void deleteReceptionist(int rid) {
        adminclient.deleteReceptionist(rid);
        receptionistsList = adminclient.getAllReceptionist(receptionistGenericType);
    }

    // Edit  Receptionist
    Receptionist SelectedReceptionist;

    public void editReceptionist(Receptionist receptionist) {
        this.SelectedReceptionist = receptionist;
        this.rid = receptionist.getId();
        this.firstName = receptionist.getFirstName();
        this.lastName = receptionist.getLastName();
        this.joiningDate = receptionist.getJoiningDate();
        this.Qualification = receptionist.getQualification();
        this.contact_Number = receptionist.getContactNumber();
        this.Gender = receptionist.getGender();
    }

    //======================== Patient methods ==================================================
    //get Patient
    public Collection<PatientDetails> getAllPatient() {
        return patientList;
    }

    //======================== Availability methods ==================================================
    //get Availability
    public Collection<AvailabilityDetails> getAllAvailability() {
        return availabilityList;
    }

    //======================== Bill methods ==================================================
    //get Bill
    public Collection<BillingDetails> getAllBill() {
        return billingList;
    }

    public Response getBillById(int billId) {
        return adminclient.getBillById(billId);
    }
    //======================== Speciality methods ==================================================

    //get Speciality
    public Collection<SpecialityMaster> getAllSpeciality() {
        return specialityList;
    }

    //======================== Visit methods ==================================================
    //get Visit
    public Collection<VisitDetails> getAllVisit() {
        return visitList;
    }

    /**
     * Creates a new instance of AdminManagedBean
     */
    public AdminManagedBean() {
    }

}
