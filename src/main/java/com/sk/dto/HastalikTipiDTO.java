package com.sk.dto;

import java.util.List;

import com.sk.model.HastalikTipiIcerik;

public class HastalikTipiDTO {
	
	private int id;
	private String hastalik_tipi_adi;
	private List<HastalikTipiIcerik> hastalik_tipi_icerik;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHastalik_tipi_adi() {
		return hastalik_tipi_adi;
	}
	public void setHastalik_tipi_adi(String hastalik_tipi_adi) {
		this.hastalik_tipi_adi = hastalik_tipi_adi;
	}
	public List<HastalikTipiIcerik> getHastalik_tipi_icerik() {
		return hastalik_tipi_icerik;
	}
	public void setHastalik_tipi_icerik(List<HastalikTipiIcerik> hastalik_tipi_icerik) {
		this.hastalik_tipi_icerik = hastalik_tipi_icerik;
	}
	
	

}
