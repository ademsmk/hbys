package com.sk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sk.dao.HastalikTipiDao;
import com.sk.model.HastalikTipi;

public class HastalikTipiServiceImp implements HastalikTipiService{
	
	@Autowired
	HastalikTipiDao hastaliktipiDao;

	@Override
	public List<HastalikTipi> getHastalikTipi() {
		// TODO Auto-generated method stub
		return hastaliktipiDao.getHastalikTipi();
	}

	@Override
	public List<HastalikTipi> getHastalikTipi(int randevu_no) {
		// TODO Auto-generated method stub
		return hastaliktipiDao.getHastalikTipi();
	}

	@Override
	public HastalikTipi getHastalikTipi(String id) {
		// TODO Auto-generated method stub
		return hastaliktipiDao.getHastalikTipi(id);
	}

	@Override
	public void addHastalikTipi(int randevu_no, HastalikTipi hastaliktipi) {
		
		hastaliktipiDao.addHastalikTipi(randevu_no, hastaliktipi);
		
	}

}
