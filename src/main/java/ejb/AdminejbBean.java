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
import entity.Receptionist;
import entity.RoleMaster;
import entity.SpecialityMaster;
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
public class AdminejbBean implements AdminejbBeanLocal {

    @PersistenceContext(unitName = "hsmspu")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Collection<RoleMaster> getAllRole() {
        return em.createNamedQuery("RoleMaster.findAll", RoleMaster.class).getResultList();
    }

    @Override
    public void addRole(RoleMaster role) {
        em.persist(role);
    }

    @Override
    public void deleteRole(Integer id) {
        RoleMaster rm = (RoleMaster) em.find(RoleMaster.class, id);
        em.remove(rm);
    }

    @Override
    public RoleMaster getRoleById(Integer Id) {
        return em.createNamedQuery("RoleMaster.findById", RoleMaster.class)
                .setParameter("id", Id)
                .getSingleResult();
    }

    @Override
    public Collection<AppointmentDetails> getAllAppointment() {
        return em.createNamedQuery("AppointmentDetails.findAll", AppointmentDetails.class).getResultList();
    }

    //DoctorDetail
    @Override
    public Collection<DoctorsDetails> getAlldoctor() {
        return em.createNamedQuery("DoctorsDetails.findAll", DoctorsDetails.class).getResultList();
    }

    @Override
    public void addDoctor(DoctorsDetails d) {
        em.persist(d);
    }

    @Override
    public void deleteDoctor(Integer id) {
        DoctorsDetails d = (DoctorsDetails) em.find(DoctorsDetails.class, id);
        em.remove(d);
    }

    @Override
    public DoctorsDetails getDoctorById(Integer Id) {
        return em.createNamedQuery("DoctorsDetails.findById", DoctorsDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }

    @Override
    public Collection<PatientDetails> getAllPatient() {
        return em.createNamedQuery("PatientDetails.findAll", PatientDetails.class).getResultList();
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
    public BillingDetails getBillById(Integer Id) {
        return em.createNamedQuery("BillingDetails.findById", BillingDetails.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }

    @Override
    public Collection<SpecialityMaster> getAllSpeciality() {
        return em.createNamedQuery("SpecialityMaster.findAll", SpecialityMaster.class).getResultList();
    }

    @Override
    public Collection<VisitDetails> getAllVisit() {
        return em.createNamedQuery("VisitDetails.findAll", VisitDetails.class).getResultList();
    }

    @Override
    public Collection<Receptionist> getAllReceptionist() {
        return em.createNamedQuery("Receptionist.findAll", Receptionist.class).getResultList();
    }

    @Override
    public void addReceptionist(Receptionist r) {
        em.persist(r);
    }

    @Override
    public void deleteReceptionist(Integer id) {
        Receptionist r = (Receptionist) em.find(Receptionist.class, id);
        em.remove(r);
    }

    @Override
    public Receptionist getReceptionistById(Integer Id) {
        return em.createNamedQuery("Receptionist.findById", Receptionist.class)
                .setParameter("Id", Id)
                .getSingleResult();
    }

}
