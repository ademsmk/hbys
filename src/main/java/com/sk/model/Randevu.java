package com.sk.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="randevu")
@Component
public class Randevu {
	
	@Id
    @Column(name = "randevu_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int randevu_no;
	
	
	private String randevu_tarihi;
	private String randevu_saati;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
            name="randevu_hastalýk_tip",
            joinColumns = @JoinColumn( name="randevu_no"),
            inverseJoinColumns = @JoinColumn( name="hastalik_tipi_id")
    )
	private List<HastalikTipi> hastalik_tipi;
	
	
	
	
	public List<HastalikTipi> getHastalik_tipi() {
		return hastalik_tipi;
	}
	public void setHastalik_tipi(List<HastalikTipi> hastalik_tipi) {
		this.hastalik_tipi = hastalik_tipi;
	}
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
