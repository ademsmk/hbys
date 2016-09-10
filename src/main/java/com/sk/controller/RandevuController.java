package com.sk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.sk.dto.HastalikTipiDTO;
import com.sk.dto.HastalikTipiIcerikDTO;
import com.sk.dto.PatientDTO;
import com.sk.model.BilgiGirisi;
import com.sk.model.HastalikTipi;
import com.sk.model.HastalikTipiIcerik;
import com.sk.model.Patient;
import com.sk.model.Randevu;
import com.sk.model.Yorumlar;
import com.sk.services.HastalikTipiIcerikService;
import com.sk.services.HastalikTipiService;
import com.sk.services.PatientService;
import com.sk.services.RandevuService;
import com.sk.services.YorumlarService;

@Controller
@Transactional
@RequestMapping("/randevu")
public class RandevuController {
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	RandevuService randevuService;
	
	@Autowired
	HastalikTipiService hastaliktipiService;
	
	@Autowired
	HastalikTipiIcerikService hastaliktipiicerikService;
	
	@Autowired
	YorumlarService yorumlarService;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public String getRecords(Model model) {
   

     List<Patient> hastalar = patientService.getPatientList();
     List<PatientDTO> patientDTO = new ArrayList<PatientDTO>();
      
     for (Patient hasta: hastalar) {
    	 
    	 PatientDTO dto = new PatientDTO();
      
    	 
    	 dto.setDosya_no(hasta.getDosya_no());
    	 dto.setAdisoyadi(hasta.getAdisoyadi());
    	 dto.setDogum_tarihi(hasta.getDogum_tarihi());
    	 dto.setDogum_yeri(hasta.getDogum_yeri());
    	 dto.setBaba_adi(hasta.getBaba_adi());
    	 dto.setAnne_adi(hasta.getAnne_adi());
    	 dto.setAdres(hasta.getAdres());
    	 dto.setTelefon_no(hasta.getTelefon_no());
    	 dto.setTckimlik_no(hasta.getTckimlik_no());
    	 dto.setCinsiyet(hasta.getCinsiyet());
    	 dto.setMedeni_hal(hasta.getMedeni_hal());
    	 dto.setKan_grubu(hasta.getKan_grubu());
    	 dto.setRandevular(randevuService.getRandevuList(hasta.getDosya_no()));
    	 dto.setSehirler(hasta.getSehirler());
    	
	    
	   patientDTO.add(dto);
     }
      
    
     model.addAttribute("hastalar", patientDTO);
     
     model.addAttribute("randevuForm", new Randevu());
     
 
     
  return "randevu";
 }
	
//	 @RequestMapping(value = "/search", method = RequestMethod.POST)
//	    public String deneme(@ModelAttribute("randevuForm") Randevu randevu){
//		 	ModelAndView model = new ModelAndView("randevu");
//		 	
//		  	String randevu_tarihi = (String) randevu.getRandevu_tarihi();
//		  	model.addObject("TariheGoreRandevu", randevuService.getRandevuListTarih(randevu_tarihi));
//		  	
////	        model.addObject("searchForm", patientService.getPatient(id));
//	        return "redirect:../randevu";
//	 }
	
	 @RequestMapping(value = "/search")
	    public ModelAndView HastaDetay(@ModelAttribute("randevuForm") Randevu randevu){
		  	ModelAndView model = new ModelAndView("randevu");
		  	model.addObject("randevuForm", new Randevu());
		  	String randevu_tarihi = randevu.getRandevu_tarihi();
		  	model.addObject("TariheGoreRandevu", randevuService.getRandevuListTarih(randevu_tarihi));
	        

	        return model;
	    }
	 
//	 @RequestMapping(value = "/search", method = RequestMethod.GET)
//	    public String deneme(@RequestParam("id") String randevu_no,@RequestParam("dosya_no") String dosya_no){
//		 
//	        return "redirect:../randevu/randevudetay?id="+randevu_no+"&dosya_no="+dosya_no;
//	 }
	
	@RequestMapping(method = RequestMethod.POST)
    public String AddRandevu(@RequestParam("randevu_no") int dosya_no,@ModelAttribute("randevuForm") Randevu randevu){
		
		String id = Integer.toString(dosya_no);
		randevu.setPatient(patientService.getPatient(id));
		randevuService.addRandevu(dosya_no, randevu);
        return "redirect:patient/randevular?id="+dosya_no;
    }
	
	 @RequestMapping(value = "/randevudetay")
	    public ModelAndView HastaDetay(@RequestParam("id") String randevu_no, @RequestParam("dosya_no") String dosya_no){
		  	ModelAndView model = new ModelAndView("randevu-detay");
	        model.addObject("RandevuDetay", randevuService.getRandevu(randevu_no));
	        model.addObject("hastalik_tipi", randevuService.getHastalikTipi());
	       
	        Patient hasta = patientService.getPatient(dosya_no);
	        String hasta_adi=hasta.getAdisoyadi();
	        model.addObject("hasta_adi", hasta_adi);
	        model.addObject("dosya_no", dosya_no);
	        

	        return model;
	    }
	 
	 @RequestMapping(value = "/hastaliktipidetay")
	 
	    public ModelAndView HastalikTipiDetay(@RequestParam("randevu_no") String randevu_no, @RequestParam("hastaliktipiid") String hastalik_tipi_id, @RequestParam("dosya_no") String dosya_no){
		  	ModelAndView model = new ModelAndView("hastaliktipi-detay");
		  	
		  	 Patient hasta = patientService.getPatient(dosya_no);
		     String hasta_adi=hasta.getAdisoyadi();
		     model.addObject("hasta_adi", hasta_adi);
		  	
		  	
	        model.addObject("RandevuDetay", randevuService.getRandevu(randevu_no));
	        model.addObject("hastalik_tipi_icerik", hastaliktipiicerikService.getHastalikTipiIcerik(hastalik_tipi_id));
	        
	        HastalikTipi hastaliktipi = hastaliktipiService.getHastalikTipi(hastalik_tipi_id);
	        List<HastalikTipiDTO> hastaliktipiDTO = new ArrayList<HastalikTipiDTO>();
	        
	        HastalikTipiDTO dto = new HastalikTipiDTO();
	        dto.setHastalik_tipi_adi(hastaliktipi.getHastalik_tipi_adi());
	        dto.setId(hastaliktipi.getId());
	        dto.setHastalik_tipi_icerik(hastaliktipiicerikService.getHastalikTipiIcerik(hastaliktipi.getId()));
	        hastaliktipiDTO.add(dto);
	        
	        String hastaliktipi_adi = hastaliktipi.getHastalik_tipi_adi();
	        model.addObject("hastalik_tipi_adi",hastaliktipi_adi);
	        model.addObject("hastaliktipi", hastaliktipiDTO);
	        model.addObject("hastaliktipi_id", hastalik_tipi_id);
	        model.addObject("dosya_no", dosya_no);
	       
 
	        return model;
	    }
	 
	 
	 @RequestMapping(value = "/icerikdetay")
	 
	    public ModelAndView icerik(@RequestParam("randevu_no") String randevu_no, @RequestParam("hastaliktipiid") String hastalik_tipi_id, @RequestParam("icerik") String icerik_id, @RequestParam("dosya_no") String dosya_no){
		  
		 	ModelAndView model = new ModelAndView("icerik-detay");
		 	
		 	Patient hasta = patientService.getPatient(dosya_no);
		    String hasta_adi=hasta.getAdisoyadi();
		    model.addObject("hasta_adi", hasta_adi);
		 	
		 	
		 	HastalikTipi hastaliktipi = hastaliktipiService.getHastalikTipi(hastalik_tipi_id);
		 	HastalikTipiIcerik icerik = hastaliktipiicerikService.getHastalikTipiIcerik(icerik_id);
		 	List<HastalikTipiIcerikDTO> icerikDTO = new ArrayList<HastalikTipiIcerikDTO>();
		 	
		 	HastalikTipiIcerikDTO dto = new HastalikTipiIcerikDTO();
		 	
		 	dto.setId(icerik.getId());
		 	dto.setHastalik_icerik_adi(icerik.getHastalik_icerik_adi());
		 	dto.setBilgigirisi(hastaliktipiicerikService.getBilgiGirisi(icerik.getId()));
		 	icerikDTO.add(dto);
		 	
		 	String hastaliktipi_adi = hastaliktipi.getHastalik_tipi_adi();
		 	String icerik_adi = icerik.getHastalik_icerik_adi();
		 	model.addObject("icerik_adi",icerik_adi);
		 	 model.addObject("hastalik_tipi_adi",hastaliktipi_adi);
		 	Yorumlar yorumlar = new Yorumlar();
			model.addObject("yorumForm", yorumlar);
			
			
			model.addObject("hastaliktipiid", hastalik_tipi_id);
		 	model.addObject("icerik", icerikDTO);
		 	model.addObject("hastaliktipi_id", hastalik_tipi_id);
		 	model.addObject("RandevuDetay", randevuService.getRandevu(randevu_no));
		 	model.addObject("dosya_no", dosya_no);
		 	

	        return model;
	    }
	 
		@RequestMapping(value = "/yorumeklemesayfasi")
	    public ModelAndView YorumEkle(@RequestParam("randevu_no") String randevu_no, 
	    		@RequestParam("hastaliktipiid") String hastalik_tipi_id, @RequestParam("icerik") String icerik_id, @RequestParam("bilgi_id") String bilgi_id, @RequestParam("dosya_no") String dosya_no){
			
			ModelAndView model = new ModelAndView("yorum-ekle-sayfasi");
			
			Patient hasta = patientService.getPatient(dosya_no);
		    String hasta_adi=hasta.getAdisoyadi();
		    model.addObject("hasta_adi", hasta_adi);
		    model.addObject("dosya_no", dosya_no);
		    model.addObject("icerik_id", icerik_id);
		    
		    BilgiGirisi bilgigirisi = hastaliktipiicerikService.getBilgiGirisi(bilgi_id);
		    String bilgigirisi_adi = bilgigirisi.getBilgi_giris_adi();
		   
		    model.addObject("bilgigirisi_adi", bilgigirisi_adi);
			
		    
		    HastalikTipi hastaliktipi = hastaliktipiService.getHastalikTipi(hastalik_tipi_id);
		 	HastalikTipiIcerik icerik = hastaliktipiicerikService.getHastalikTipiIcerik(icerik_id);
			String hastaliktipi_adi = hastaliktipi.getHastalik_tipi_adi();
		 	String icerik_adi = icerik.getHastalik_icerik_adi();
		 	model.addObject("icerik_adi",icerik_adi);
		 	model.addObject("hastalik_tipi_adi",hastaliktipi_adi);
			Yorumlar yorumlar = new Yorumlar();
			model.addObject("yorumForm", yorumlar);
			model.addObject("icerik", icerik_id);
			model.addObject("bilgi_id", bilgi_id);
			model.addObject("hastaliktipiid", hastalik_tipi_id);
			model.addObject("randevu_no", randevu_no);
			model.addObject("yorumList", yorumlarService.getYorumlarList(randevu_no, bilgi_id));
			model.addObject("RandevuDetay", randevuService.getRandevu(randevu_no));
			
		return model;
			
			
			
	    }
	 
		@RequestMapping(value = "/yorumekle", method = RequestMethod.POST)
	    public String AddSummary(@ModelAttribute("yorumForm") Yorumlar yorumlar,@RequestParam("randevu_no") String randevu_no, 
	    		@RequestParam("hastaliktipiid") String hastalik_tipi_id, @RequestParam("icerik") String icerik_id, @RequestParam("bilgi_id") String bilgi_id, @RequestParam("dosya_no") String dosya_no  ){
			
			
			yorumlar.setBilgigirisi(hastaliktipiicerikService.getBilgiGirisi(bilgi_id));
			yorumlar.setRandevu(randevuService.getRandevu(randevu_no));
			hastaliktipiicerikService.YorumEkle(yorumlar);
			HastalikTipi hastaliktipi = hastaliktipiService.getHastalikTipi(hastalik_tipi_id);
			hastaliktipiService.addHastalikTipi(randevu_no, hastaliktipi);
			
			
	        return "redirect:../randevu/yorumeklemesayfasi?hastaliktipiid="+hastalik_tipi_id+"&randevu_no="+randevu_no+"&icerik="+icerik_id+"&bilgi_id="+bilgi_id+"&dosya_no="+dosya_no;
	    }
	 
	 

	
	
}
