/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.AppointmentDetails;
import entity.AvailabilityDetails;
import entity.BillingDetails;
import entity.DoctorsDetails;
import entity.PatientDetails;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dell
 */
@Stateless
public class PatientejbBean implements PatientejbBeanLocal {

    @PersistenceContext(unitName = "hsmspu")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public AppointmentDetails getAppointmentById(Integer Id) {
        return em.createNamedQuery("AppointmentDetails.findById", AppointmentDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }

    //DoctorDetail
    @Override
    public Collection<DoctorsDetails> getAlldoctor() {
        return em.createNamedQuery("DoctorsDetails.findAll", DoctorsDetails.class).getResultList();
    }
    
    @Override
    public Collection<AvailabilityDetails> getAllAvailability() {
        return em.createNamedQuery("AvailabilityDetails.findAll", AvailabilityDetails.class).getResultList();
    }

    
    @Override
    public AvailabilityDetails getAvailabilityById(Integer Id) {
        return em.createNamedQuery("AvailabilityDetails.findById", AvailabilityDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }
    
    @Override
    public BillingDetails getBillById(Integer Id) {
        return em.createNamedQuery("BillingDetails.findById", BillingDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }

    @Override
    public PatientDetails getPatientById(Integer Id) {
       return  em.createNamedQuery("PatientDetails.findById",PatientDetails.class)
               .setParameter("Id", Id)
                .getSingleResult();
    }

   
}
