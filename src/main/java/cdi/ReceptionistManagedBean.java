/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.ReceptionistClient;
import entity.AppointmentDetails;
import entity.AvailabilityDetails;
import entity.BillingDetails;
import entity.DoctorsDetails;
import entity.PatientDetails;
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

/**
 *
 * @author Dell
 */
@Named(value = "receptionistManagedBean")
@SessionScoped
public class ReceptionistManagedBean implements Serializable {

    @Inject
    private ReceptionistClient receptionistClient;
    private Collection<AppointmentDetails> appointmentList;
    private Collection<AvailabilityDetails> availabilityList;
    private Collection<BillingDetails> billingList;
    private Collection<DoctorsDetails> doctorsList;
    private Collection<PatientDetails> patientList;
    private Collection<VisitDetails> visitList;

    private AppointmentDetails appointmentDetails;
    private AvailabilityDetails availabilityDetails;
    private BillingDetails billingDetails;
    private DoctorsDetails doctorsDetails;
    private PatientDetails patientDetails;
    private VisitDetails visitDetails;

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

    private final GenericType<Collection<VisitDetails>> visitGenericType = new GenericType<Collection<VisitDetails>>() {
    };

    private void safeLoad(Runnable task) {
        try {
            task.run();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
    }

    @PostConstruct
    public void init() {
        try {
            receptionistClient = new ReceptionistClient();
//            appointmentList = receptionistClient.getAllAppointment(appointmentGenericType);
//            availabilityList = receptionistClient.getAllAvailability(availabilityGenericType);
//            billingList = receptionistClient.getAllBill(billGenericType);
//            doctorsList = receptionistClient.getAlldoctor(doctorGenericType);
//            patientList = receptionistClient.getAllPatient(patientGenericType);
//            visitList = receptionistClient.getAllVisit(visitGenericType);

        } catch (ClientErrorException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new instance of ReceptionistManagedBean
     */
    public ReceptionistManagedBean() {
    }

    //======================== Appointment methods ==================================================
    //getAppointment
//    public Collection<AppointmentDetails> getAllAppointment() {
//        return appointmentList;
//    }
//
//    //Add Appointment
//    public void addAppointment() {
//        try {
//            boolean appointmentExists = appointmentList.stream()
//                    .anyMatch(appointment -> appointment.getId().equals(id));
//
//            if (appointmentExists) {
//                System.out.println("Appointment already exists.");
//            }
//            AppointmentDetails newAppointment = new AppointmentDetails();
//            newAppointment.setId(id);
//            newAppointment.setAppointmentDate(appointmentDate);
//            newAppointment.setStatus(status);
//            newAppointment.setNotes(notes);
//            newAppointment.setPatientId(appointmentDetails.getPatientId());
//            newAppointment.setDoctorId(appointmentDetails.getDoctorId());
//
//            appointmentList = receptionistClient.getAppointmentById(appointmentGenericType);
//            id = 0;
//            appointmentDate = null;
//            status = "";
//            notes = "";
//            patientId = 0;
//            doctorId = 0;
//        } catch (ClientErrorException e) {
//            System.out.println("Failed to add Appointment.");
//        }
//    }
//
//    //Delete Appointment
//    public void deleteAppointment(int id) {
//        receptionistClient.deleteAppointment(id);
//        appointmentList = receptionistClient.getAllAppointment(appointmentGenericType);
//    }
//
//    // Edit  Appointment
//    AppointmentDetails SelectedAppointment;
//
//    public void editAppointment(AppointmentDetails appointment) {
//        this.SelectedAppointment = appointment;
//        this.id = appointment.getId();
//        this.appointmentDate = appointment.getAppointmentDate();
//        this.status = appointment.getStatus();
//        this.notes = appointment.getNotes();
//        this.patientDetails = appointmentDetails.getPatientId();
//        this.doctorsDetails = appointment.getDoctorId();
//    }
//
//    //======================== Doctor methods ==================================================
//    //getDoctor
//    public Collection<DoctorsDetails> getAlldoctor() {
//        return doctorsList;
//    }
//
//    //======================== Patient methods ==================================================
//    //get Patient
//    public Collection<PatientDetails> getAllPatient() {
//        return patientList;
//    }
//
//    //Add Patient
//    public void addPatient() {
//        try {
//            boolean patientExists = patientList.stream()
//                    .anyMatch(patient -> patient.getFirstName().equalsIgnoreCase(fName));
//
//            if (patientExists) {
//                System.out.println("Patient already exists.");
//            }
//            PatientDetails newpatient = new PatientDetails();
//            newpatient.setId(pid);
//            newpatient.setFirstName(fName);
//            newpatient.setLastName(lName);
//            newpatient.setDob(dob);
//            newpatient.setGender(gender);
//            newpatient.setContactNumber(cont_Number);
//
//            patientList = receptionistClient.getAllPatient(patientGenericType);
//            id = 0;
//            fName = "";
//            lName = "";
//            dob = null;
//            gender = "";
//            cont_Number = 0;
//        } catch (ClientErrorException e) {
//            System.out.println("Failed to add Patient.");
//        }
//    }
//
//    //Delete Patient
//    public void deletePatient(int pid) {
//        receptionistClient.deletePatient(pid);
//        patientList = receptionistClient.getAllPatient(patientGenericType);
//    }
//
//    // Edit  Patient
//    PatientDetails SelectedPatient;
//
//    public void editPatient(PatientDetails patient) {
//        this.SelectedPatient = patient;
//        this.pid = patient.getId();
//        this.fName = patient.getFirstName();
//        this.lName = patient.getLastName();
//        this.dob = patient.getDob();
//        this.gender = patient.getGender();
//        this.cont_Number = patient.getContactNumber();
//    }
//
//    //======================== Availability methods ==================================================
//    //get Availability
//    public Collection<AvailabilityDetails> getAllAvailability() {
//        return availabilityList;
//    }
//
//    //======================== Bill methods ==================================================
//    //get Bill
//    public Collection<BillingDetails> getAllBill() {
//        return billingList;
//    }
}
