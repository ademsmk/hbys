package com.sk.dto;

import java.util.List;

import com.sk.model.BilgiGirisi;

public class HastalikTipiIcerikDTO {
	
	private int id;
	private String hastalik_icerik_adi;
	private List<BilgiGirisi> bilgigirisi;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHastalik_icerik_adi() {
		return hastalik_icerik_adi;
	}
	public void setHastalik_icerik_adi(String hastalik_icerik_adi) {
		this.hastalik_icerik_adi = hastalik_icerik_adi;
	}
	public List<BilgiGirisi> getBilgigirisi() {
		return bilgigirisi;
	}
	public void setBilgigirisi(List<BilgiGirisi> bilgigirisi) {
		this.bilgigirisi = bilgigirisi;
	}
	
	

}
