package com.sk.dao;

import java.util.List;

import com.sk.model.Randevu;

public interface RandevuDao {
	
	public List<Randevu> getRandevuList(int dosya_no);
	public List<Randevu> getRandevuList();
	public Randevu getRandevu(String id);
	public void deleteRandevu(String id);
	public void editRandevu(Randevu randevu);
	public void addRandevu(int dosya_no, Randevu randevu);
	

}
