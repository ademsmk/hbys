package com.sk.services;

import java.util.List;

import com.sk.model.HastalikTipi;
import com.sk.model.Randevu;

public interface RandevuService {
	
	public List<Randevu> getRandevuList(int dosya_no);
	public List<Randevu> getRandevuList();
	public Randevu getRandevu(String id);
	public void deleteRandevu(String id);
	public void editRandevu(Randevu randevu);
	public void addRandevu(int dosya_no, Randevu randevu);
	public List<HastalikTipi> getHastalikTipi();
}
