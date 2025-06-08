/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.PatientClient;
import entity.AppointmentDetails;
import entity.AvailabilityDetails;
import entity.DoctorsDetails;
import entity.BillingDetails;
import entity.PatientDetails;
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
@Named(value = "patientManagedBean")
@SessionScoped
public class PatientManagedBean implements Serializable {

    @Inject
    private PatientClient patientClient;
    private Collection<PatientDetails> patientList;
    private Collection<AppointmentDetails> appointmentList;
    private Collection<AvailabilityDetails> availabilityList;
    private Collection<DoctorsDetails> doctorsList;
    private Collection<BillingDetails> billingList;

    //============== PatientDetails ===============
    private Integer pid;
    private String fName;
    private String lName;
    private Date dob;
    private String gender;
    private int co_Number;

    //============== AppointmentDetails ===============
    private Integer id;
    private Date appointmentDate;
    private String status;
    private String notes;
    private Integer patientId;
    private DoctorsDetails doctorId;

    //============== AvailabilityDetails ===============
    private Integer aid;
    private int dayOfWeek;
    private Date startTime;
    private Date endTime;
    private Integer dId;

    //============== DoctorsDetails ===============
    private Integer did;
    private String firstName;
    private String lastName;
    private String qualification;
    private int workingHours;
    private int contactNumber;

    //============== BillingDetails ===============
    private Integer bid;
    private double billAmount;
    private Date billingDate;
    private String paymentStatus;
    private Integer pId;
    private Integer visitId;
    private Integer medicineId;

    private final GenericType<Collection<PatientDetails>> patientGenericType = new GenericType<Collection<PatientDetails>>() {
    };

    private final GenericType<Collection<AppointmentDetails>> appointmentGenericType = new GenericType<Collection<AppointmentDetails>>() {
    };

    private final GenericType<Collection<AvailabilityDetails>> availabilityGenericType = new GenericType<Collection<AvailabilityDetails>>() {
    };

    private final GenericType<Collection<DoctorsDetails>> doctorGenericType = new GenericType<Collection<DoctorsDetails>>() {
    };

    private final GenericType<Collection<BillingDetails>> billGenericType = new GenericType<Collection<BillingDetails>>() {
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
            patientClient = new PatientClient();
//            patientList = patientClient.getPatientById(patientGenericType);
//            appointmentList = patientClient.getAppointmentById(appointmentGenericType);
//            availabilityList = patientClient.getAllAvailability(availabilityGenericType);
//            billingList = patientClient.getBillById(billGenericType);
//            doctorsList = patientClient.getAlldoctor(doctorGenericType);

        } catch (ClientErrorException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //======================== Appointment methods ==================================================
    //Add Appointment
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
//            PatientDetails patient = patientClient.getPatientById(patientId);
//            newAppointment.setPatientId(patient);
//            newAppointment.setDoctorId(doctorId);
//
//            appointmentList = patientClient.getAppointmentById(appointmentGenericType);
//            id = 0;
//            appointmentDate = null;
//            status = "";
//            notes = "";
//            patientId = 0;
//            doctorId = null;
//        } catch (ClientErrorException e) {
//            System.out.println("Failed to add Appointment.");
//        }
//    }
//
//    //======================== Doctor methods ==================================================
//    //getDoctor
//    public Collection<DoctorsDetails> getAlldoctor() {
//        return doctorsList;
//    }
//
//    //======================== Availability methods ==================================================
//    //get Availability
//    public Collection<AvailabilityDetails> getAllAvailability() {
//        return availabilityList;
//    }
    /**
     * Creates a new instance of PatientManagedBean
     */
    public PatientManagedBean() {
    }

}
