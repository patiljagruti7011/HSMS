/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.DoctorClient;
import entity.AppointmentDetails;
import entity.AvailabilityDetails;
import entity.BillingDetails;
import entity.DoctorsDetails;
import entity.PatientDetails;
import entity.ReportType;
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

/**
 *
 * @author Dell
 */
@Named(value = "doctorManagedBean")
@SessionScoped
public class DoctorManagedBean implements Serializable {

//    @Inject    
    private DoctorClient doctorClient;
    private Collection<AppointmentDetails> appointmentList;
    private Collection<AvailabilityDetails> availabilityList;
    private Collection<DoctorsDetails> doctorsList;
    private Collection<PatientDetails> patientList;
    private Collection<ReportType> reportList;
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

    //============== ReportType ===============
    private Integer rid;
    private String reportName;

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

    private final GenericType<Collection<DoctorsDetails>> doctorGenericType = new GenericType<Collection<DoctorsDetails>>() {
    };

    private final GenericType<Collection<PatientDetails>> patientGenericType = new GenericType<Collection<PatientDetails>>() {
    };

    private final GenericType<Collection<ReportType>> reportGenericType = new GenericType<Collection<ReportType>>() {
    };

    private final GenericType<Collection<SpecialityMaster>> specialityGenericType = new GenericType<Collection<SpecialityMaster>>() {
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
            doctorClient = new DoctorClient();
            appointmentList = doctorClient.getAllAppointment(appointmentGenericType);
            availabilityList = doctorClient.getAllAvailability(availabilityGenericType);
            doctorsList = doctorClient.getAlldoctor(doctorGenericType);
            patientList = doctorClient.getAllPatient(patientGenericType);
            reportList = doctorClient.getAllReport(reportGenericType);
            specialityList = doctorClient.getAllSpeciality(specialityGenericType);
            visitList = doctorClient.getAllVisit(visitGenericType);

        } catch (ClientErrorException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    //Add Availability
    public void addAvailability() {
        try {
            boolean availabilityExists = availabilityList.stream()
                    .anyMatch(availability -> availability.getId().equals(aid));

            if (availabilityExists) {
                System.out.println("Availability name already exists.");
            }
            AvailabilityDetails newAvailability = new AvailabilityDetails();
            newAvailability.setId(aid);
            newAvailability.setDayOfWeek(0);
            newAvailability.setStartTime(null);
            newAvailability.setEndTime(null);
            DoctorsDetails doctor = doctorClient.getDoctorById(doctorId);
            newAvailability.setDoctorId(doctor);

            availabilityList = doctorClient.getAllAvailability(availabilityGenericType);
            aid = 0;
            dayOfWeek = 0;
            startTime = null;
            endTime = null;
            dId = 0;

        } catch (ClientErrorException e) {
            System.out.println("Failed to add Receptionist.");
        }
    }

    //Delete Availability
    public void deleteAvailability(int aid) {
        doctorClient.deleteAvailability(aid);
        availabilityList = doctorClient.getAllAvailability(availabilityGenericType);
    }

    // Edit  Availability
    AvailabilityDetails SelectedAvailability;

    public void editAvailability(AvailabilityDetails availability) {
        this.SelectedAvailability = availability;
        this.aid = availability.getId();
        this.dayOfWeek = availability.getDayOfWeek();
        this.startTime = availability.getStartTime();
        this.endTime = availability.getEndTime();
        this.dId = availability.getDoctorId().getId();
    }

    //======================== ReportType methods ==================================================
    //get ReportType
    public Collection<ReportType> getAllReport() {
        return reportList;
    }

    //Add ReportType
    public void addReport() {
        try {
            boolean reportExists = reportList.stream()
                    .anyMatch(report -> report.getId().equals(aid));

            if (reportExists) {
                System.out.println("Report name already exists.");
            }
            ReportType newReport = new ReportType();
            newReport.setId(rid);
            newReport.setReportName("");
            reportList = doctorClient.getAllReport(reportGenericType);
            rid = 0;
            reportName = "";

        } catch (ClientErrorException e) {
            System.out.println("Failed to add Receptionist.");
        }
    }

    //Delete ReportType
    public void deleteReport(int rid) {
        doctorClient.deleteReport(rid);
        reportList = doctorClient.getAllReport(reportGenericType);
    }

    // Edit  ReportType
    ReportType SelectedReport;

    public void editReport(ReportType report) {
        this.SelectedReport = report;
        this.rid = report.getId();
        this.reportName = report.getReportName();
    }

    //======================== SpecialityMaster methods ==================================================
    //get Speciality
    public Collection<SpecialityMaster> getAllSpeciality() {
        return specialityList;
    }

    //Add Speciality
    public void addSpeciality() {
        try {
            boolean SpecialityExists = specialityList.stream()
                    .anyMatch(Speciality -> Speciality.getId().equals(sid));

            if (SpecialityExists) {
                System.out.println("Speciality name already exists.");
            }
            SpecialityMaster newSpeciality = new SpecialityMaster();
            newSpeciality.setId(sid);
            newSpeciality.setSpeciality("");
            specialityList = doctorClient.getAllSpeciality(specialityGenericType);
            sid = 0;
            speciality = "";

        } catch (ClientErrorException e) {
            System.out.println("Failed to add Speciality.");
        }
    }

    //Delete Speciality
    public void deleteSpeciality(int sid) {
        doctorClient.deleteSpeciality(sid);
        specialityList = doctorClient.getAllSpeciality(specialityGenericType);
    }

    // Edit  Speciality
    SpecialityMaster SelectedSpeciality;

    public void editSpeciality(SpecialityMaster Speciality) {
        this.SelectedSpeciality = Speciality;
        this.sid = Speciality.getId();
        this.speciality = Speciality.getSpeciality();
    }

    //======================== Visit methods ==================================================
    //get Visit
    public Collection<VisitDetails> getAllVisit() {
        return visitList;
    }

    /**
     * Creates a new instance of DoctorManagedBean
     */
    public DoctorManagedBean() {
    }

}
