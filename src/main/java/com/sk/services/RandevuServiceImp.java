package com.sk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sk.dao.RandevuDao;
import com.sk.model.Randevu;

public class RandevuServiceImp implements RandevuService {

	@Autowired
	RandevuDao randevuDao;
	
	@Override
	public List<Randevu> getRandevuList(int dosya_no) {
		
		return randevuDao.getRandevuList(dosya_no);
	}

	@Override
	public List<Randevu> getRandevuList() {
		
		return randevuDao.getRandevuList();
	}

	@Override
	public Randevu getRandevu(String id) {
		
		return randevuDao.getRandevu(id);
	}

	@Override
	public void deleteRandevu(String id) {
		
		randevuDao.deleteRandevu(id);
		
	}

	@Override
	public void editRandevu(Randevu randevu) {
		
		randevuDao.editRandevu(randevu);
		
	}

	@Override
	public void addRandevu(int dosya_no, Randevu randevu) {
		
		randevuDao.addRandevu(dosya_no, randevu);
		
	}

}
