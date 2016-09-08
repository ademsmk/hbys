package com.sk.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.sk.model.HastalikTipi;
import com.sk.model.Randevu;

public class HastalikTipiDaoImp implements HastalikTipiDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<HastalikTipi> getHastalikTipi() {
		Session session = sessionFactory.getCurrentSession();
		List<HastalikTipi> list=session.createQuery("from HastalikTipi").list();
		return list;
	}

	@Override
	public List<HastalikTipi> getHastalikTipi(int randevu_no) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Randevu as r LEFT JOIN FETCH  r.hastalik_tipi WHERE r.randevu_no="+randevu_no);
		Randevu randevu = (Randevu) query.uniqueResult();
		return new ArrayList<HastalikTipi>(randevu.getHastalik_tipi());
	}

	@Override
	public HastalikTipi getHastalikTipi(String id) {
		Session session = sessionFactory.getCurrentSession();
		HastalikTipi hastaliktipi = (HastalikTipi) session.get(HastalikTipi.class, new Integer(id));
		return hastaliktipi;
	}

	@Override
	public void addHastalikTipi(String randevu_no, HastalikTipi hastaliktipi) {
		 Session session = sessionFactory.getCurrentSession();
		 session.save(hastaliktipi);
		 Randevu existingRandevu = (Randevu) session.get(Randevu.class, new Integer(randevu_no));
		 existingRandevu.getHastalik_tipi().add(hastaliktipi);
		 session.save(existingRandevu);
	}

}
