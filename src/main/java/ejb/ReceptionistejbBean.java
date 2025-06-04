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
import entity.VisitDetails;
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
public class ReceptionistejbBean implements ReceptionistejbBeanLocal {

    @PersistenceContext(unitName = "hsmspu")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Collection<AppointmentDetails> getAllAppointment() {
        return em.createNamedQuery("AppointmentDetails.findAll", AppointmentDetails.class).getResultList();
    }

    @Override
    public void addAppointment(int id, Date apDate, String status, String notes, PatientDetails pid, DoctorsDetails did) {
        AppointmentDetails a = new AppointmentDetails();
        a.setId(id);
        a.setAppointmentDate(apDate);
        a.setNotes(notes);
        a.setStatus(status);
        a.setPatientId(pid);
        a.setDoctorId(did);
        
        em.persist(a);
    }

    @Override
    public void deleteAppointment(Integer id) {
        AppointmentDetails a = (AppointmentDetails) em.find(AppointmentDetails.class, id);
        em.remove(a);

    }

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
    public Collection<PatientDetails> getAllPatient() {
        return em.createNamedQuery("PatientDetails.findAll", PatientDetails.class).getResultList();
    }

    @Override
    public void addPatient(Integer id, String firstName, String lastName, Date dob, String gender, int contactNumber) {
        PatientDetails p = new PatientDetails();
        p.setId(id);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setDob(dob);
        p.setGender(gender);
        p.setContactNumber(contactNumber);
        em.persist(p);
    }

    @Override
    public void deletePatient(Integer id) {
        PatientDetails p = (PatientDetails) em.find(PatientDetails.class, id);
        em.remove(p);

    }
    
    @Override
    public PatientDetails getPatientById(Integer Id) {
        return em.createNamedQuery("PatientDetails.findById", PatientDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
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
    public Collection<BillingDetails> getAllBill() {
        return em.createNamedQuery("BillingDetails.findAll", BillingDetails.class).getResultList();
    }

    @Override
    public void addBill(Integer id, double billAmount, Date billingDate, String paymentStatus) {
        BillingDetails bill = new BillingDetails();
        bill.setId(id);
        bill.setBillAmount(billAmount);
        bill.setBillingDate(billingDate);
        bill.setPaymentStatus(paymentStatus);
        em.persist(bill);
    }

    @Override
    public void deleteBill(Integer id) {
        BillingDetails b = (BillingDetails) em.find(BillingDetails.class, id);
        em.remove(b);
    }
    
    @Override
    public BillingDetails getBillById(Integer Id) {
        return em.createNamedQuery("BillingDetails.findById", BillingDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }
    

    @Override
    public Collection<VisitDetails> getAllVisit() {
        return em.createNamedQuery("VisitDetails.findAll", VisitDetails.class).getResultList();
    }

    @Override
    public void addVisit(Integer id, Date visitDate, double visitCharge) {
        VisitDetails v = new VisitDetails();
        v.setId(id);
        v.setVisitDate(visitDate);
        v.setVisitCharge(visitCharge);
        em.persist(v);
    }

    @Override
    public void deleteVisit(Integer id) {
        VisitDetails v = (VisitDetails) em.find(VisitDetails.class, id);
        em.remove(v);
    }
    
    @Override
    public VisitDetails getvisitById(Integer Id) {
        return em.createNamedQuery("VisitDetails.findById", VisitDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }

}
