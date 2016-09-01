package com.sk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="hasta")
@Component
public class Patient {
	
		@Id
	    @Column(name = "dosya_no")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int dosya_no;
		
	    private String adisoyadi;
	    private String dogum_tarihi;
	    private String dogum_yeri;
	    private String baba_adi;
	    private String anne_adi;
	    private String adres;
	    private String tckimlik_no;
	    private String telefon_no;
	    private String cinsiyet;
	    private String medeni_hal;
	    private String kan_grubu;
	    
	    public Sehir getSehirler() {
			return sehirler;
		}
		public void setSehirler(Sehir sehirler) {
			this.sehirler = sehirler;
		}
		@OneToOne
		@JoinColumn(name="sehir_kodu")
		private Sehir sehirler;
	    
	    
	    public String getMedeni_hal() {
			return medeni_hal;
		}
		public void setMedeni_hal(String medeni_hal) {
			this.medeni_hal = medeni_hal;
		}
		
	    
		public String getKan_grubu() {
			return kan_grubu;
		}
		public void setKan_grubu(String kan_grubu) {
			this.kan_grubu = kan_grubu;
		}
		public String getCinsiyet() {
			return cinsiyet;
		}
		public void setCinsiyet(String cinsiyet) {
			this.cinsiyet = cinsiyet;
		}
		public String getTelefon_no() {
			return telefon_no;
		}
		public void setTelefon_no(String telefon_no) {
			this.telefon_no = telefon_no;
		}
		public String getBaba_adi() {
			return baba_adi;
		}
		public void setBaba_adi(String baba_adi) {
			this.baba_adi = baba_adi;
		}
		public String getAnne_adi() {
			return anne_adi;
		}
		public void setAnne_adi(String anne_adi) {
			this.anne_adi = anne_adi;
		}
		public String getAdres() {
			return adres;
		}
		public void setAdres(String adres) {
			this.adres = adres;
		}
	
	
		public String getTckimlik_no() {
			return tckimlik_no;
		}
		public void setTckimlik_no(String tckimlik_no) {
			this.tckimlik_no = tckimlik_no;
		}
		public int getDosya_no() {
			return dosya_no;
		}
		public void setDosya_no(int dosya_no) {
			this.dosya_no = dosya_no;
		}

		public String getAdisoyadi() {
			return adisoyadi;
		}
		public void setAdisoyadi(String adisoyadi) {
			this.adisoyadi = adisoyadi;
		}
		public String getDogum_tarihi() {
			return dogum_tarihi;
		}
		public void setDogum_tarihi(String dogum_tarihi) {
			this.dogum_tarihi = dogum_tarihi;
		}
		public String getDogum_yeri() {
			return dogum_yeri;
		}
		public void setDogum_yeri(String dogum_yeri) {
			this.dogum_yeri = dogum_yeri;
		}
	    
	    
	    
	    
	
		
	    
	    
}
