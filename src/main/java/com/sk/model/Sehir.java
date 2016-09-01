package com.sk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="sehirler")
@Component
public class Sehir {
	
	@Id
    @Column(name = "sehir_kodu")
	private int sehirkodu;
	
	private String sehiradi;
	

	public int getSehirkodu() {
		return sehirkodu;
	}

	public void setSehirkodu(int sehirkodu) {
		this.sehirkodu = sehirkodu;
	}

	public String getSehiradi() {
		return sehiradi;
	}

	public void setSehiradi(String sehiradi) {
		this.sehiradi = sehiradi;
	}
	
	

}
