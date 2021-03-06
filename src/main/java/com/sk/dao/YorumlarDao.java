package com.sk.dao;

import java.util.List;

import com.sk.model.Yorumlar;

public interface YorumlarDao {
	
	public Yorumlar getYorumlar(String bilgi_girisi_id);
	public void deleteYorum(String yorum_id);
	public void editYorum(Yorumlar Yorumlar);
	public void addYorum(Yorumlar yorumlar);
	public List<Yorumlar> getYorumlarList(String randevu_no,String bilgigirisi_id);

}
