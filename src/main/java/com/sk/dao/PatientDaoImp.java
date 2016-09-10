package com.sk.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sk.model.Patient;
import com.sk.model.Randevu;
import com.sk.model.Sehir;

@Repository
public class PatientDaoImp implements PatientDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
//	public void setSessionFactory(SessionFactory sessionFactory){
//        this.sessionFactory=sessionFactory;
//    }

	@Override
	public List<Patient> getPatientList() {
		 Session session=this.sessionFactory.getCurrentSession();
	        List<Patient> list=session.createQuery("from Patient").list();
	        return list;
	}

	@Override
	public void delete(String id) {
		 Session session=this.sessionFactory.getCurrentSession();
		 Query query = session.createQuery("FROM Patient as p LEFT JOIN FETCH p.randevular WHERE p.dosya_no="+id);
		 Patient patient = (Patient) query.uniqueResult();
		 session.delete(patient);
		 
		 List<Randevu> randevular = patient.getRandevular();
		 
		 for(Randevu randevu : randevular){
			 
			 session.delete(randevu);
		 }
//		 
//		 Patient patient=(Patient)session.get(Patient.class,new Integer(id));
//	        if(patient!=null){ 
//	        session.delete(patient);
//	        }
		
	}

	@Override
	public void insertData(Patient hasta) {
		
		 Session session=this.sessionFactory.getCurrentSession();
	       session.save(hasta);
		
	}


	@Override
	public Patient getPatient(String id) {
		
		 Session session=this.sessionFactory.getCurrentSession();
		 Patient patient=(Patient)session.get(Patient.class,new Integer(id));
	     return patient;
		
		
	}
	
	@Override
	public void updatePatient(Patient patient) {
		
		 Session session=this.sessionFactory.getCurrentSession();
	      session.update(patient);
		
	}

	@Override
	public List<Sehir> getSehirList() {
		Session session=this.sessionFactory.getCurrentSession();
        List<Sehir> list=session.createQuery("from Sehir").list();
        return list;
	}

	@Override
	public List<Patient> getPatientList(int page_baslangic_id, int total) {
		Session session = sessionFactory.getCurrentSession();
		List<Patient> list = session.createSQLQuery("SELECT * FROM hasta limit "+page_baslangic_id+","+total).list();
		return list;
	}







}
