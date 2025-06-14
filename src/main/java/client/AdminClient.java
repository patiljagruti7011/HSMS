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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:AdminRestResource
 * [adminRest]<br>
 * USAGE:
 * <pre>
 *        AdminClient client = new AdminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Dell
 */
public class AdminClient implements Serializable {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/HSMS/resources";

    public AdminClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("adminRest");
    }

    /**
     * @param responseType
     * @return
     * @param <T>
     * @RoleMaster
     */
    public <T> T getAllRole(GenericType<T> responseType) throws ClientErrorException {
        return webTarget.path("getAllRole").request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getRoleById(GenericType<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getRoleById/{id}").resolveTemplate("id", id);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addRole(Object requestEntity) throws ClientErrorException {
        webTarget.path("addRole").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public Response deleteRole(int roleid) throws ClientErrorException {
        return webTarget.path("deleteRole/{id}")
                .resolveTemplate("id", roleid)
                .request()
                .delete();

    }

    /**
     *
     * @param <T>
     * @param responseType
     * @return
     * @throws ClientErrorException
     * @DoctorDetails
     */
    public <T> T getAlldoctor(GenericType<T> responseType) throws ClientErrorException {
        return webTarget.path("getAlldoctor").request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getDoctorById(GenericType<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getDoctorById/{id}").resolveTemplate("id", id);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addDoctor(Object requestEntity) throws ClientErrorException {
        webTarget.path("addDoctor").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public Response deleteDoctor(int did) throws ClientErrorException {
        return webTarget.path("deleteDoctor/{id}")
                .resolveTemplate("id", did)
                .request()
                .delete();
    }

    /**
     *
     * @param <T>
     * @param responseType
     * @return
     * @throws ClientErrorException
     * @Receptionist
     */
    public <T> T getAllReceptionist(GenericType<T> responseType) throws ClientErrorException {
        return webTarget.path("getAllReceptionist").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getReceptionistById(GenericType<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getReceptionistById/{id}").resolveTemplate("id", id);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addReceptionist(Object requestEntity) throws ClientErrorException {
        webTarget.path("addReceptionist").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public Response deleteReceptionist(int rid) throws ClientErrorException {
        return webTarget.path("deleteReceptionist/{id}")
                .resolveTemplate("id", rid)
                .request()
                .delete();
    }

    /**
     *
     * @param <T>
     * @param responseType
     * @return
     * @throws ClientErrorException
     * @AvailabilityDetails
     */
    public <T> T getAllAvailability(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllAvailability");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAvailabilityById(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAvailabilityById");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *
     * @param <T>
     * @param responseType
     * @return
     * @throws ClientErrorException
     * @BillingDetails
     */
    public <T> T getAllBill(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllBill");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response getBillById(int billId) throws ClientErrorException {

        return webTarget.path("getBillById/{id}")
                .resolveTemplate("id", billId)
                .request().get();
    }

    public <T> T getAllPatient(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPatient");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllVisit(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllVisit");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllSpeciality(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllSpeciality");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllAppointment(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllAppointment");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void close() {
        client.close();
    }

}
