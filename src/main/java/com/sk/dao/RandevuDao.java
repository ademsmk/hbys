package com.sk.dao;

import java.util.List;

import com.sk.model.HastalikTipi;
import com.sk.model.HastalikTipiIcerik;
import com.sk.model.Randevu;

public interface RandevuDao {
	
	public List<Randevu> getRandevuList(int dosya_no);
	public List<Randevu> getRandevuListTarih(String randevu_tarihi);
	public List<Randevu> getRandevuList();
	public Randevu getRandevu(String id);
	public Randevu getRandevuTarih(String randevu_tarihi);
	public void deleteRandevu(String id);
	public void editRandevu(Randevu randevu);
	public void addRandevu(int dosya_no, Randevu randevu);
	public List<HastalikTipi> getHastalikTipi();
	public List<HastalikTipiIcerik> getHastalikTipiIcerik(int hastalik_tipi_id);
	

}
