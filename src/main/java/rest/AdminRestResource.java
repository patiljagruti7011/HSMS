/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.AdminejbBeanLocal;
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
@Path("adminRest")
@RequestScoped
public class AdminRestResource {

    @EJB 
    AdminejbBeanLocal aebl;
    
    @Context
    private UriInfo context;

    //----------------------------------------RoleMaster------------------------------------------
    @GET
    @Path("getAllRole")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<RoleMaster> getAllRole() {
        return aebl.getAllRole();
    }
    
    @GET
    @Path("getRoleById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoleById(@PathParam("id") int id) {
        RoleMaster role = aebl.getRoleById(id);
        if (role != null) {
            aebl.getRoleById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Role not found").build();
        }
    }

    @POST
    @Path("addRole")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addRole(int id, String username, String password, String role, int pid, int did) {
        aebl.addRole(id,username,password,role,pid,did);
    }

    @DELETE
    @Path("deleteRole")
    public Response deleteRole(@PathParam("id") int id) {
        RoleMaster role = aebl.getRoleById(id);
        if (role != null) {
            aebl.deleteRole(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Role not found").build();
        }
    }
    
    //----------------------------------------Appointment------------------------------------------
    
    @GET
    @Path("getAllAppointment")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AppointmentDetails> getAllAppointment() {
        return aebl.getAllAppointment();
    }

    

    //----------------------------------------Doctor------------------------------------------
    @GET
    @Path("getAlldoctor")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<DoctorsDetails> getAlldoctor() {
        return aebl.getAlldoctor();
    }
    
    @GET
    @Path("getDoctorById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorById(@PathParam("id") int id) {
        DoctorsDetails doctor = aebl.getDoctorById(id);
        if (doctor != null) {
            aebl.getDoctorById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
        }
    }

    @POST
    @Path("addDoctor")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDoctor(int id, String fname, String lname, String Qualification, int wh, int cno) {
        aebl.addDoctor(id,fname,lname,Qualification,wh,cno);
    }

    @DELETE
    @Path("deleteDoctor")
    public Response deleteDoctor(@PathParam("id") int id) {
        DoctorsDetails doctor = aebl.getDoctorById(id);
        if (doctor != null) {
            aebl.deleteDoctor(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
        }
    }

    //----------------------------------------Receptionist------------------------------------------
    @GET
    @Path("getAllReceptionist")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Receptionist> getAllReceptionist() {
        return aebl.getAllReceptionist();
    }
    
    @GET
    @Path("getReceptionistById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReceptionistById(@PathParam("id") int id) {
        Receptionist receptionist = aebl.getReceptionistById(id);
        if (receptionist != null) {
            aebl.getReceptionistById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Receptionist not found").build();
        }
    }

    @POST
    @Path("addReceptionist")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addReceptionist(int id, String fname, String lname, Date joining, String qauli, String cno, String gender) {
        aebl.addReceptionist(id,fname,lname,joining,qauli,cno,gender);
    }

    @DELETE
    @Path("deleteReceptionist")
    public Response deleteReceptionist(@PathParam("id") int id) {
        Receptionist receptionist = aebl.getReceptionistById(id);
        if (receptionist != null) {
            aebl.deleteReceptionist(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Receptionist not found").build();
        }
    }
    
    //----------------------------------------Patient------------------------------------------
    @GET
    @Path("getAllPatient")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<PatientDetails> getAllPatient() {
        return aebl.getAllPatient();
    }


    //----------------------------------------Availability------------------------------------------
    @GET
    @Path("getAllAvailability")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AvailabilityDetails> getAllAvailability() {
        return aebl.getAllAvailability();
    }

    @GET
    @Path("getAvailabilityById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailabilityById(@PathParam("id") int id) {
        AvailabilityDetails availability = aebl.getAvailabilityById(id);
        if (availability != null) {
            aebl.getAvailabilityById(id);
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
        return aebl.getAllBill();
    }

    
    @GET
    @Path("getBillById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillById(@PathParam("id") int id) {
        BillingDetails bill = aebl.getBillById(id);
        if (bill != null) {
            aebl.getBillById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Bill not found").build();
        }
    }
    
    //----------------------------------------SpecialityMaster------------------------------------------
    @GET
    @Path("getAllSpeciality")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SpecialityMaster> getAllSpeciality() {
        return aebl.getAllSpeciality();
    }

   
    //----------------------------------------VisitDetails------------------------------------------
    @GET
    @Path("getAllVisit")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<VisitDetails> getAllVisit() {
        return aebl.getAllVisit();
    }

    /**
     * Creates a new instance of AdminRestResource
     */
    public AdminRestResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AdminRestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AdminRestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
