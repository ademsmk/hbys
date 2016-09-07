package com.sk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sk.dao.YorumlarDao;
import com.sk.model.Yorumlar;

public class YorumlarServiceImp implements YorumlarService{
	
	@Autowired
	YorumlarDao yorumlarDao;

	@Override
	public Yorumlar getYorumlar(String bilgi_girisi_id) {
		// TODO Auto-generated method stub
		return yorumlarDao.getYorumlar(bilgi_girisi_id);
	}

	@Override
	public void deleteYorum(String yorum_id) {
		// TODO Auto-generated method stub
		yorumlarDao.deleteYorum(yorum_id);
	}

	@Override
	public void editYorum(Yorumlar Yorumlar) {
		// TODO Auto-generated method stub
		yorumlarDao.editYorum(Yorumlar);
	}

	@Override
	public void addYorum(Yorumlar yorumlar) {
		// TODO Auto-generated method stub
		yorumlarDao.addYorum(yorumlar);
	}

	@Override
	public List<Yorumlar> getYorumlarList(String randevu_no) {
		// TODO Auto-generated method stub
		return yorumlarDao.getYorumlarList(randevu_no);
	}

	

	
}
