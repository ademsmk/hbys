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
@Table(name="hastalik_tipi_icerigi")
@Component
public class HastalikTipiIcerik {
	
	@Id
    @Column(name = "hastalik_icerik_id")
	private int id;
	private String hastalik_icerik_adi;

	
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
            name="icerik_bilgi_girisi",
            joinColumns = @JoinColumn( name="hastalik_icerik_id"),
            inverseJoinColumns = @JoinColumn( name="bilgi_giris_id")
    )
	private List<BilgiGirisi> bilgigirisi;
	
	
	
	

	public List<BilgiGirisi> getBilgigirisi() {
		return bilgigirisi;
	}
	public void setBilgigirisi(List<BilgiGirisi> bilgigirisi) {
		this.bilgigirisi = bilgigirisi;
	}
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
	
	

}
