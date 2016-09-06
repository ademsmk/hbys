package com.sk.dto;

import java.util.List;


import com.sk.model.HastalikTipi;

public class RandevuDTO {
	
	private int randevu_no;
	private String randevu_tarihi;
	private String randevu_saati;
	private List<HastalikTipi> hastalik_tipi;
	
	
	
	public int getRandevu_no() {
		return randevu_no;
	}
	public void setRandevu_no(int randevu_no) {
		this.randevu_no = randevu_no;
	}
	public String getRandevu_tarihi() {
		return randevu_tarihi;
	}
	public void setRandevu_tarihi(String randevu_tarihi) {
		this.randevu_tarihi = randevu_tarihi;
	}
	public String getRandevu_saati() {
		return randevu_saati;
	}
	public void setRandevu_saati(String randevu_saati) {
		this.randevu_saati = randevu_saati;
	}
	public List<HastalikTipi> getHastalik_tipi() {
		return hastalik_tipi;
	}
	public void setHastalik_tipi(List<HastalikTipi> hastalik_tipi) {
		this.hastalik_tipi = hastalik_tipi;
	}
	
	

}
