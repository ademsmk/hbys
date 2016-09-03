package com.sk.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.sk.model.Patient;
import com.sk.model.Randevu;

public class RandevuDaoImp implements RandevuDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Randevu> getRandevuList(int dosya_no) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Patient as p LEFT JOIN FETCH  p.randevular WHERE p.dosya_no="+dosya_no);
		Patient patient = (Patient) query.uniqueResult();
		return new ArrayList<Randevu>(patient.getRandevular());
		
	}

	@Override
	public List<Randevu> getRandevuList() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Randevu> list=session.createQuery("from Randevu").list();
        return list;
	}

	@Override
	public Randevu getRandevu(String id) {
		
		Session session = sessionFactory.getCurrentSession();
		Randevu randevu=(Randevu)session.get(Randevu.class,new Integer(id));
		return randevu;
	}

	@Override
	public void deleteRandevu(String id) {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("DELETE FROM hasta_randevu WHERE randevu_no="+id);
		query.executeUpdate();
		Randevu randevu=(Randevu)session.get(Randevu.class,new Integer(id));
	        if(randevu!=null){ 
	        session.delete(randevu);
	        }
		
	}

	@Override
	public void editRandevu(Randevu randevu) {
		
		Session session=this.sessionFactory.getCurrentSession();
	      session.update(randevu);
		
	}

	@Override
	public void addRandevu(int dosya_no, Randevu randevu) {
		
		  Session session = sessionFactory.getCurrentSession();
		  session.save(randevu);
		  Patient existingPatient = (Patient) session.get(Patient.class, dosya_no);
		  existingPatient.getRandevular().add(randevu);
		  session.save(existingPatient);
		
	}

}
