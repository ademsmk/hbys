package com.sk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="randevu")
@Component
public class Randevu {
	
	@Id
    @Column(name = "randevu_no")
	private int randevu_no;
	
	
	private String randevu_tarihi;
	private String randevu_saati;
	
	
	
	
	public String getRandevu_saati() {
		return randevu_saati;
	}
	public void setRandevu_saati(String randevu_saati) {
		this.randevu_saati = randevu_saati;
	}
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
	
	
	

}
