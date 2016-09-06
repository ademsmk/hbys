package com.sk.dto;

import java.util.List;

import com.sk.model.Randevu;
import com.sk.model.Sehir;

public class PatientDTO {
	
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
    private List<Randevu> randevular;
    private Sehir sehirler;
    
    
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
	public String getTelefon_no() {
		return telefon_no;
	}
	public void setTelefon_no(String telefon_no) {
		this.telefon_no = telefon_no;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
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
	public List<Randevu> getRandevular() {
		return randevular;
	}
	public void setRandevular(List<Randevu> randevular) {
		this.randevular = randevular;
	}
	public Sehir getSehirler() {
		return sehirler;
	}
	public void setSehirler(Sehir sehirler) {
		this.sehirler = sehirler;
	}
    
    
    
    

}
