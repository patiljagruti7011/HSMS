/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import entity.DoctorsDetails;
import java.io.Serializable;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:DoctorRestResource
 * [doctorRest]<br>
 * USAGE:
 * <pre>
 *        DoctorClient client = new DoctorClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Dell
 */
public class DoctorClient implements Serializable {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/HSMS/resources";

    public DoctorClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("doctorRest");
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

//    public <T> T getAlldoctor(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAlldoctor");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public void addSpeciality(Object requestEntity) throws ClientErrorException {
//        webTarget.path("addSpeciality").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//
//    public Response deleteAvailability(int aid) throws ClientErrorException {
//        return webTarget.path("deleteAvailability/{id}")
//                .resolveTemplate("id", aid)
//                .request()
//                .delete();
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
//    public <T> T getAllVisit(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllVisit");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getAllSpeciality(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllSpeciality");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getVisitById(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getvisitById");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getReportById(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getReportById");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getAllAppointment(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllAppointment");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//
//    public <T> T getDoctorById(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getDoctorById");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public void addAvailability(Object requestEntity) throws ClientErrorException {
//        webTarget.path("addAvailability").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//
//    public <T> T getAllReport(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllReport");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T getSpecialityById(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getSpecialityById");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public void addReport(Object requestEntity) throws ClientErrorException {
//        webTarget.path("addReport").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
//
//    public Response deleteReport(int rid) throws ClientErrorException {
//        return webTarget.path("deleteReport/{id}")
//                .resolveTemplate("id", rid)
//                .request()
//                .delete();
//    }
//    
//    
//    public <T> T getAvailabilityById(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAvailabilityById");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public Response deleteSpeciality(int sid) throws ClientErrorException {
//        return webTarget.path("deleteSpeciality/{id}")
//                .resolveTemplate("id", sid)
//                .request()
//                .delete();
//    }
//
//    public <T> T getAllAvailability(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllAvailability");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
//     public DoctorsDetails getDoctorById(Integer Id){
//        WebTarget resource = webTarget.path("getDoctorById").path(String.valueOf(Id));
//        return resource.request(MediaType.APPLICATION_JSON).get(DoctorsDetails.class);
//    }
    public void close() {
        client.close();
    }

}
