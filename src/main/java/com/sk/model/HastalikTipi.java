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
@Table(name="hastalik_tipi")
@Component
public class HastalikTipi {
	
	@Id
    @Column(name = "hastalik_tipi_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hastalik_tipi_adi;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
            name="hastalik_tip_icerik",
            joinColumns = @JoinColumn( name="hastalik_tipi_id"),
            inverseJoinColumns = @JoinColumn( name="hastalik_icerik_id")
    )
	private List<HastalikTipiIcerik> hastalik_tipi_icerik;

	
	
	


	public List<HastalikTipiIcerik> getHastalik_tipi_icerik() {
		return hastalik_tipi_icerik;
	}
	public void setHastalik_tipi_icerik(List<HastalikTipiIcerik> hastalik_tipi_icerik) {
		this.hastalik_tipi_icerik = hastalik_tipi_icerik;
	}
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
	
	

}
