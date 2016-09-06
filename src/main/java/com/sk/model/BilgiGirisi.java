package com.sk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="bilgi_girisi")
@Component
public class BilgiGirisi {
	
	@Id
    @Column(name = "bilgi_giris_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bilgi_giris_adi;

	
	
	

	public String getBilgi_giris_adi() {
		return bilgi_giris_adi;
	}
	public void setBilgi_giris_adi(String bilgi_giris_adi) {
		this.bilgi_giris_adi = bilgi_giris_adi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
