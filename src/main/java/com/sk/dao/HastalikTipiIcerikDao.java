package com.sk.dao;

import java.util.List;

import com.sk.model.BilgiGirisi;
import com.sk.model.HastalikTipi;
import com.sk.model.HastalikTipiIcerik;

public interface HastalikTipiIcerikDao {
	
	public List<HastalikTipiIcerik> getHastalikTipiIcerik();
	public List<HastalikTipiIcerik> getHastalikTipiIcerik(int hastalik_tipi_id);
	public HastalikTipiIcerik getHastalikTipiIcerik(String id);
	public List<BilgiGirisi> getBilgiGirisi(int icerik_id);

}
