package com.sk.services;

import java.util.List;

import com.sk.model.HastalikTipi;

public interface HastalikTipiService {
	
	public List<HastalikTipi> getHastalikTipi();
	public List<HastalikTipi> getHastalikTipi(int randevu_no);
	public HastalikTipi getHastalikTipi(String id);
	public void addHastalikTipi(int randevu_no, HastalikTipi hastaliktipi);

}
