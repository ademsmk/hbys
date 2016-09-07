package com.sk.dao;

import java.util.List;

import com.sk.model.HastalikTipi;
import com.sk.model.Sehir;

public interface HastalikTipiDao {
	
	public List<HastalikTipi> getHastalikTipi();
	public List<HastalikTipi> getHastalikTipi(int randevu_no);
	public HastalikTipi getHastalikTipi(String id);
	public void addHastalikTipi(String randevu_no, HastalikTipi hastaliktipi);
	
}
