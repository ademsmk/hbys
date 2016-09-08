package com.sk.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sk.model.Yorumlar;



public class YorumlarDaoImp implements YorumlarDao {
	
	@Autowired
	SessionFactory sessionFactory;





	@Override
	public void addYorum(Yorumlar yorumlar) {
		Session session = sessionFactory.getCurrentSession();
		session.save(yorumlar);
		
	}

	@Override
	public void deleteYorum(String yorum_id) {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("DELETE FROM yorumlar WHERE yorum_id="+yorum_id);
		query.executeUpdate();
		
	}

	@Override
	public Yorumlar getYorumlar(String bilgi_girisi_id) {
		Session session = sessionFactory.getCurrentSession();
		Yorumlar yorumlar = (Yorumlar) session.get(Yorumlar.class, new Integer(bilgi_girisi_id));
		return yorumlar;
	}

	@Override
	public void editYorum(Yorumlar Yorumlar) {
		Session session = sessionFactory.getCurrentSession();
		session.update(Yorumlar);
		
	}

	@Override
	public List<Yorumlar> getYorumlarList(String randevu_no, String bilgigirisi_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Yorumlar as y where y.randevu.randevu_no ="+randevu_no+"and y.bilgigirisi.id="+bilgigirisi_id);
		List list = query.list();
		return list;
	}
	
	
	
}
