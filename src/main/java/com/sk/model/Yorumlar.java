package com.sk.model;

import javax.persistence.CascadeType;
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
@Component
@Table(name = "yorumlar")
public class Yorumlar {
	
	@Id
	@Column(name="yorum_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String yorum;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bilgi_girisi_id")
	private BilgiGirisi bilgigirisi;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getYorum() {
		return yorum;
	}


	public void setYorum(String yorum) {
		this.yorum = yorum;
	}


	public BilgiGirisi getBilgigirisi() {
		return bilgigirisi;
	}


	public void setBilgigirisi(BilgiGirisi bilgigirisi) {
		this.bilgigirisi = bilgigirisi;
	}

	
	
}
