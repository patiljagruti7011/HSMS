/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.ReceptionistejbBeanLocal;
import entity.AppointmentDetails;
import entity.AvailabilityDetails;
import entity.BillingDetails;
import entity.DoctorsDetails;
import entity.PatientDetails;
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
@Path("receptionistRest")
@RequestScoped
public class ReceptionistRestResource {

    @EJB
    ReceptionistejbBeanLocal rbl;
    
    @Context
    private UriInfo context;

   
    @GET
    @Path("getAllAppointment")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AppointmentDetails> getAllAppointment() {
        return rbl.getAllAppointment();
    }
    
    @GET
    @Path("getAppointmentById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentById(@PathParam("id") int id) {
        AppointmentDetails appointment = rbl.getAppointmentById(id);
        if (appointment != null) {
            rbl.getAppointmentById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found").build();
        }
    }

    @POST
    @Path("addAppointment")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointment(int id, Date apDate, String status, String notes, PatientDetails pid, DoctorsDetails did) {
        rbl.addAppointment(id,apDate,status,notes,pid,did);
    }

    @DELETE
    @Path("deleteAppointment")
    public Response deleteAppointment(@PathParam("id") int id) {
        AppointmentDetails appointment = rbl.getAppointmentById(id);
        if (appointment != null) {
            rbl.deleteAppointment(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found").build();
        }
    }

    //----------------------------------------Doctor------------------------------------------
    @GET
    @Path("getAlldoctor")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<DoctorsDetails> getAlldoctor() {
        return rbl.getAlldoctor();
    }

   
    //----------------------------------------Patient------------------------------------------
    @GET
    @Path("getAllPatient")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<PatientDetails> getAllPatient() {
        return rbl.getAllPatient();
    }
    
    @GET
    @Path("getPatientById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("id") int id) {
        PatientDetails patient = rbl.getPatientById(id);
        if (patient != null) {
            rbl.getPatientById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
        }
    }


    @POST
    @Path("addPatient")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(Integer id, String firstName, String lastName, Date dob, String gender, int contactNumber) {
        rbl.addPatient(id,firstName,lastName,dob,gender,contactNumber);
    }

    @DELETE
    @Path("deletePatient")
    public Response deletePatient(@PathParam("id") int id) {
        PatientDetails patient = rbl.getPatientById(id);
        if (patient != null) {
            rbl.deletePatient(id);
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
        return rbl.getAllAvailability();
    }

    @GET
    @Path("getAvailabilityById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailabilityById(@PathParam("id") int id) {
        AvailabilityDetails availability = rbl.getAvailabilityById(id);
        if (availability != null) {
            rbl.getAvailabilityById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Availability not found").build();
        }
    }
  
    //----------------------------------------Bill------------------------------------------
    @GET
    @Path("getAllBill")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<BillingDetails> getAllBill() {
        return rbl.getAllBill();
    }
    
    @GET
    @Path("getBillById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillById(@PathParam("id") int id) {
        BillingDetails bill = rbl.getBillById(id);
        if (bill != null) {
            rbl.getBillById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Bill not found").build();
        }
    }


    @POST
    @Path("addBill")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBill(Integer id, double billAmount, Date billingDate, String paymentStatus) {
        rbl.addBill(id,billAmount,billingDate,paymentStatus);
    }

    @DELETE
    @Path("deleteBill")
    public Response deleteBill(@PathParam("id") int id) {
        BillingDetails bill = rbl.getBillById(id);
        if (bill != null) {
            rbl.deleteBill(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Bill not found").build();
        }
    }

    //----------------------------------------VisitDetails------------------------------------------
    @GET
    @Path("getAllVisit")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<VisitDetails> getAllVisit() {
        return rbl.getAllVisit();
    }
    
    @GET
    @Path("getvisitById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVisitById(@PathParam("id") int id) {
        VisitDetails visit = rbl.getvisitById(id);
        if (visit != null) {
            rbl.getvisitById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("VisitDetails not found").build();
        }
    }


    @POST
    @Path("addVisit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addVisit(Integer id, Date visitDate, double visitCharge) {
        rbl.addVisit(id,visitDate,visitCharge);
    }

    @DELETE
    @Path("deleteVisit")
    public Response deleteVisit(@PathParam("id") int id) {
        VisitDetails visit = rbl.getvisitById(id);
        if (visit != null) {
            rbl.deleteVisit(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("VisitDetails not found").build();
        }
    }


    
}
