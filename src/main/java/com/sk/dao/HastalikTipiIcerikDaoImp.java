package com.sk.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sk.model.BilgiGirisi;
import com.sk.model.HastalikTipi;
import com.sk.model.HastalikTipiIcerik;
import com.sk.model.Yorumlar;

public class HastalikTipiIcerikDaoImp implements HastalikTipiIcerikDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<HastalikTipiIcerik> getHastalikTipiIcerik() {
		
		Session session = sessionFactory.getCurrentSession();
		List<HastalikTipiIcerik> list=session.createQuery("from HastalikTipiIcerik").list();
		return list;
	}

	@Override
	public List<HastalikTipiIcerik> getHastalikTipiIcerik(int hastalik_tipi_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM HastalikTipi as h LEFT JOIN FETCH  h.hastalik_tipi_icerik WHERE h.id="+hastalik_tipi_id);
		HastalikTipi hastaliktipi = (HastalikTipi) query.uniqueResult();
		return new ArrayList<HastalikTipiIcerik>(hastaliktipi.getHastalik_tipi_icerik());
	}

	@Override
	public HastalikTipiIcerik getHastalikTipiIcerik(String id) {
		Session session = sessionFactory.getCurrentSession();
		HastalikTipiIcerik hastaliktipiicerik = (HastalikTipiIcerik) session.get(HastalikTipiIcerik.class, new Integer(id));
		return hastaliktipiicerik;
	}

	@Override
	public List<BilgiGirisi> getBilgiGirisi(int icerik_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM HastalikTipiIcerik as ht LEFT JOIN FETCH  ht.bilgigirisi WHERE ht.id="+icerik_id);
		HastalikTipiIcerik icerik = (HastalikTipiIcerik) query.uniqueResult();
		return new ArrayList<BilgiGirisi>(icerik.getBilgigirisi());
	}

	@Override
	public BilgiGirisi getBilgiGirisi(String id) {
		Session session = sessionFactory.getCurrentSession();
		BilgiGirisi bilgigirisi = (BilgiGirisi) session.get(BilgiGirisi.class, new Integer(id));
		return bilgigirisi;
	}

	@Override
	public void YorumEkle(Yorumlar yorumlar) {
		Session session = sessionFactory.getCurrentSession();
		session.save(yorumlar);
		
	}

}
