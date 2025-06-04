/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.PatientejbBeanLocal;
import ejb.ReceptionistejbBean;
import entity.AppointmentDetails;
import entity.AvailabilityDetails;
import entity.BillingDetails;
import entity.DoctorsDetails;
import entity.PatientDetails;
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
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("patientRest")
@RequestScoped
public class PatientRestResource {

    @EJB
    PatientejbBeanLocal pbl;

    @EJB
    ReceptionistejbBean recbl;

    @Context
    private UriInfo context;

    @POST
    @Path("addAppointment")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointment(int id, Date apDate, String status, String notes, PatientDetails pid, DoctorsDetails did) {
        recbl.addAppointment(id, apDate, status, notes, pid, did);
    }

    @GET
    @Path("getAppointmentById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentById(@PathParam("id") int id) {
        AppointmentDetails appointment = pbl.getAppointmentById(id);
        if (appointment != null) {
            pbl.getAppointmentById(id);
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
        return pbl.getAlldoctor();
    }

    //----------------------------------------Availability------------------------------------------
    @GET
    @Path("getAllAvailability")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AvailabilityDetails> getAllAvailability() {
        return pbl.getAllAvailability();
    }

    @GET
    @Path("getAvailabilityById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailabilityById(@PathParam("id") int id) {
        AvailabilityDetails availability = pbl.getAvailabilityById(id);
        if (availability != null) {
            pbl.getAvailabilityById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Availability not found").build();
        }
    }

    //----------------------------------------Bill------------------------------------------
    @GET
    @Path("getBillById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillById(@PathParam("id") int id) {
        BillingDetails bill = pbl.getBillById(id);
        if (bill != null) {
            pbl.getBillById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Bill not found").build();
        }
    }
    
    //----------------------------------------Patient------------------------------------------
    @GET
    @Path("getPatientById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("id") int id) {
        PatientDetails patient = pbl.getPatientById(id);
        if (patient != null) {
            pbl.getPatientById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
