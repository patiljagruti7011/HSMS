/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.DoctorejbBeanLocal;
import entity.AppointmentDetails;
import entity.AvailabilityDetails;
import entity.DoctorsDetails;
import entity.PatientDetails;
import entity.ReportType;
import entity.SpecialityMaster;
import entity.VisitDetails;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("doctorRest")
@RequestScoped
public class DoctorRestResource {

    @EJB
    DoctorejbBeanLocal dbl;
    
    @Context
    private UriInfo context;

    @GET
    @Path("getAllAppointment")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AppointmentDetails> getAllAppointment() {
        return dbl.getAllAppointment();
    }


    //----------------------------------------Doctor------------------------------------------
    @GET
    @Path("getAlldoctor")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<DoctorsDetails> getAlldoctor() {
        return dbl.getAlldoctor();
    }

    @GET
    @Path("getDoctorById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorById(@PathParam("id") int id) {
        DoctorsDetails doctor = dbl.getDoctorById(id);
        if (doctor != null) {
            dbl.getDoctorById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
        }
    }
    //----------------------------------------Patient------------------------------------------
    @GET
    @Path("getAllPatient")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<PatientDetails> getAllPatient() {
        return dbl.getAllPatient();
    }

    @GET
    @Path("getPatientById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("id") int id) {
        PatientDetails patient = dbl.getPatientById(id);
        if (patient != null) {
            dbl.getPatientById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
        }
    }

    //----------------------------------------Availability------------------------------------------
    @GET
    @Path("getAllAvailability")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AvailabilityDetails> getAllAvailability() {
        return dbl.getAllAvailability();
    }
    
    @GET
    @Path("getAvailabilityById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailabilityById(@PathParam("id") int id) {
        AvailabilityDetails availability = dbl.getAvailabilityById(id);
        if (availability != null) {
            dbl.getAvailabilityById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Availability not found").build();
        }
    }


    @POST
    @Path("addAvailability")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAvailability(int id, int dayofweek, Date stime, Date etime, DoctorsDetails did) {
        dbl.addAvailability(id,dayofweek,stime,etime,did);
    }

    @DELETE
    @Path("deleteAvailability")
    public Response deleteAvailability(@PathParam("id") int id) {
        AvailabilityDetails availability = dbl.getAvailabilityById(id);
        if (availability != null) {
            dbl.deleteAvailability(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Availability not found").build();
        }
    }

    //----------------------------------------ReportType------------------------------------------
    @GET
    @Path("getAllReport")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ReportType> getAllReport() {
        return dbl.getAllReport();
    }
    
    @GET
    @Path("getReportById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportById(@PathParam("id") int id) {
        ReportType report = dbl.getReportById(id);
        if (report != null) {
            dbl.getReportById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Report not found").build();
        }
    }

    @POST
    @Path("addReport")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addReport(Integer id, String reportName) {
        dbl.addReport(id,reportName);
    }

    @DELETE
    @Path("deleteReport")
    public Response deleteReport(@PathParam("id") int id) {
        ReportType report = dbl.getReportById(id);
        if (report != null) {
            dbl.deleteReport(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Report not found").build();
        }
    }

    //----------------------------------------SpecialityMaster------------------------------------------
    @GET
    @Path("getAllSpeciality")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SpecialityMaster> getAllSpeciality() {
        return dbl.getAllSpeciality();
    }
     
    @GET
    @Path("getSpecialityById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecialityById(@PathParam("id") int id) {
        SpecialityMaster Speciality = dbl.getSpecialityById(id);
        if (Speciality != null) {
            dbl.getSpecialityById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Speciality not found").build();
        }
    }

    @POST
    @Path("addSpeciality")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addSpeciality(Integer id, String speciality) {
        dbl.addSpeciality(id,speciality);
    }

    @DELETE
    @Path("deleteSpeciality")
    public Response deleteSpeciality(@PathParam("id") int id) {
        SpecialityMaster Speciality = dbl.getSpecialityById(id);
        if (Speciality != null) {
            dbl.deleteSpeciality(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Speciality not found").build();
        }
    }

    //----------------------------------------VisitDetails------------------------------------------
    @GET
    @Path("getAllVisit")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<VisitDetails> getAllVisit() {
        return dbl.getAllVisit();
    }

   
    @GET
    @Path("getvisitById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVisitById(@PathParam("id") int id) {
        VisitDetails visit = dbl.getvisitById(id);
        if (visit != null) {
            dbl.getvisitById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("VisitDetails not found").build();
        }
    }


    
    /**
     * PUT method for updating or creating an instance of DoctorRestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
