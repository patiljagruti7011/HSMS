/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import java.io.Serializable;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:ReceptionistRestResource
 * [receptionistRest]<br>
 * USAGE:
 * <pre>
 *        ReceptionistClient client = new ReceptionistClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Dell
 */
public class ReceptionistClient implements Serializable {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/HSMS/resources";

    public ReceptionistClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("receptionistRest");
    }

    public void close() {
        client.close();
    }

//    public <T> T getAlldoctor(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAlldoctor");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getPatientById(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getPatientById");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getAllPatient(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllPatient");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public void addAppointment(Object requestEntity) throws ClientErrorException {
//        webTarget.path("addAppointment").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//
//    public Response deletePatient(int pid) throws ClientErrorException {
//        return webTarget.path("deletePatient/{id}")
//                .resolveTemplate("id", pid)
//                .request()
//                .delete();
//    }
//
//    public <T> T getAllVisit(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllVisit");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getVisitById(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getvisitById");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getAppointmentById(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAppointmentById");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public void addBill(Object requestEntity) throws ClientErrorException {
//        webTarget.path("addBill").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//
//    public <T> T getAllAppointment(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllAppointment");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getAllBill(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllBill");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public void addPatient(Object requestEntity) throws ClientErrorException {
//        webTarget.path("addPatient").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//
//    public <T> T getBillById(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getBillById");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public Response deleteBill() throws ClientErrorException {
//        return webTarget.path("deleteBill").request().delete(Response.class);
//    }
//
//    public Response deleteAppointment(int id) throws ClientErrorException {
//        return webTarget.path("deleteAppointment/{id}")
//                .resolveTemplate("id", id)
//                .request()
//                .delete();
//    }
//
//    public void addVisit(Object requestEntity) throws ClientErrorException {
//        webTarget.path("addVisit").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//
//    public <T> T getAvailabilityById(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAvailabilityById");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getAllAvailability(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllAvailability");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public Response deleteVisit() throws ClientErrorException {
//        return webTarget.path("deleteVisit").request().delete(Response.class);
//    }
}
