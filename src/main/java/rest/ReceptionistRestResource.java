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
    @Path("getAppointmentById/{id}")
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

//    @POST
//    @Path("addAppointment/{id}/{apDate}/{status}/{notes}/{pid}/{did}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void addAppointment(@PathParam("id") int id,
//            @PathParam("apDate") Date apDate,
//            @PathParam("status") String status,
//            @PathParam("notes") String notes,
//            @PathParam("pid") PatientDetails pid,
//            @PathParam("did") DoctorsDetails did) {
//        rbl.addAppointment(id, apDate, status, notes, pid, did);
//    }

    @DELETE
    @Path("deleteAppointment/{id}")
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
    @Path("getPatientById/{id}")
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
    @Path("addPatient/{id}/{firstName}/{lastName}/{dob}/{gender}/{contactNumber}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(@PathParam("id") Integer id,
            @PathParam("firstName") String firstName,
            @PathParam("lastName") String lastName,
            @PathParam("dob") Date dob,
            @PathParam("gender") String gender,
            @PathParam("contactNumber") int contactNumber) {
        rbl.addPatient(id, firstName, lastName, dob, gender, contactNumber);
    }

    @DELETE
    @Path("deletePatient/{id}")
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
    @Path("getAvailabilityById/{id}")
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
    @Path("getBillById/{id}")
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
    @Path("addBill/{id}/{billAmount}/{billingDate}/{paymentStatus}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBill(@PathParam("id") Integer id,
            @PathParam("billAmount") double billAmount,
            @PathParam("billingDate") Date billingDate,
            @PathParam("paymentStatus") String paymentStatus) {
        rbl.addBill(id, billAmount, billingDate, paymentStatus);
    }

    @DELETE
    @Path("deleteBill/{id}")
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
    @Path("getvisitById/{id}")
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
    @Path("addVisit/{id}/{visitDate}/{visitCharge}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addVisit(@PathParam("id") Integer id,
            @PathParam("visitDate") Date visitDate,
            @PathParam("visitCharge") double visitCharge) {
        rbl.addVisit(id, visitDate, visitCharge);
    }

    @DELETE
    @Path("deleteVisit/{id}")
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
