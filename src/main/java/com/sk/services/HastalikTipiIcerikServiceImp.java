package com.sk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sk.dao.HastalikTipiIcerikDao;
import com.sk.model.BilgiGirisi;
import com.sk.model.HastalikTipiIcerik;
import com.sk.model.Yorumlar;

public class HastalikTipiIcerikServiceImp implements HastalikTipiIcerikService{

	@Autowired
	HastalikTipiIcerikDao hastaliktipiicerikDao;
	
	@Override
	public List<HastalikTipiIcerik> getHastalikTipiIcerik() {
		return hastaliktipiicerikDao.getHastalikTipiIcerik();
	}

	@Override
	public List<HastalikTipiIcerik> getHastalikTipiIcerik(int hastalik_tipi_id) {
		// TODO Auto-generated method stub
		return hastaliktipiicerikDao.getHastalikTipiIcerik(hastalik_tipi_id);
	}

	@Override
	public HastalikTipiIcerik getHastalikTipiIcerik(String id) {
		// TODO Auto-generated method stub
		return hastaliktipiicerikDao.getHastalikTipiIcerik(id);
	}

	@Override
	public List<BilgiGirisi> getBilgiGirisi(int icerik_id) {
		// TODO Auto-generated method stub
		return hastaliktipiicerikDao.getBilgiGirisi(icerik_id);
	}

	@Override
	public BilgiGirisi getBilgiGirisi(String id) {
		// TODO Auto-generated method stub
		return hastaliktipiicerikDao.getBilgiGirisi(id);
	}

	@Override
	public void YorumEkle(Yorumlar yorumlar) {
	
		hastaliktipiicerikDao.YorumEkle(yorumlar);
	}

}
