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
     
 
     
  return "randevu";
 }
	
	@RequestMapping(method = RequestMethod.POST)
    public String AddAuthor(@RequestParam("randevu_no") Integer dosya_no,@ModelAttribute("randevuForm") Randevu randevu){
		
		randevuService.addRandevu(dosya_no, randevu);
        return "redirect:patient/randevular?id="+dosya_no;
    }
	
	 @RequestMapping(value = "/randevudetay")
	    public ModelAndView HastaDetay(@RequestParam("id") String randevu_no, @RequestParam("dosya_no") String dosya_no){
		  	ModelAndView model = new ModelAndView("randevu-detay");
	        model.addObject("RandevuDetay", randevuService.getRandevu(randevu_no));
	        model.addObject("hastalik_tipi", randevuService.getHastalikTipi());
	        model.addObject("dosya_no", dosya_no);
	        

	        return model;
	    }
	 
	 @RequestMapping(value = "/hastaliktipidetay")
	 
	    public ModelAndView HastalikTipiDetay(@RequestParam("randevu_no") String randevu_no, @RequestParam("hastaliktipiid") String hastalik_tipi_id, @RequestParam("dosya_no") String dosya_no){
		  	ModelAndView model = new ModelAndView("hastaliktipi-detay");
	        model.addObject("RandevuDetay", randevuService.getRandevu(randevu_no));
	        model.addObject("hastalik_tipi_icerik", hastaliktipiicerikService.getHastalikTipiIcerik(hastalik_tipi_id));
	        
	        HastalikTipi hastaliktipi = hastaliktipiService.getHastalikTipi(hastalik_tipi_id);
	        List<HastalikTipiDTO> hastaliktipiDTO = new ArrayList<HastalikTipiDTO>();
	        
	        HastalikTipiDTO dto = new HastalikTipiDTO();
	        dto.setHastalik_tipi_adi(hastaliktipi.getHastalik_tipi_adi());
	        dto.setId(hastaliktipi.getId());
	        dto.setHastalik_tipi_icerik(hastaliktipiicerikService.getHastalikTipiIcerik(hastaliktipi.getId()));
	        hastaliktipiDTO.add(dto);
	        
	        model.addObject("hastaliktipi", hastaliktipiDTO);
	        model.addObject("hastaliktipi_id", hastalik_tipi_id);
	        model.addObject("dosya_no", dosya_no);
 
	        return model;
	    }
	 
	 
	 @RequestMapping(value = "/icerikdetay")
	 
	    public ModelAndView icerik(@RequestParam("randevu_no") String randevu_no, @RequestParam("hastaliktipiid") String hastalik_tipi_id, @RequestParam("icerik") String icerik_id){
		  
		 	ModelAndView model = new ModelAndView("icerik-detay");
		 	HastalikTipiIcerik icerik = hastaliktipiicerikService.getHastalikTipiIcerik(icerik_id);
		 	List<HastalikTipiIcerikDTO> icerikDTO = new ArrayList<HastalikTipiIcerikDTO>();
		 	
		 	HastalikTipiIcerikDTO dto = new HastalikTipiIcerikDTO();
		 	
		 	dto.setId(icerik.getId());
		 	dto.setHastalik_icerik_adi(icerik.getHastalik_icerik_adi());
		 	dto.setBilgigirisi(hastaliktipiicerikService.getBilgiGirisi(icerik.getId()));
		 	icerikDTO.add(dto);
		 	
		 	model.addObject("icerik", icerikDTO);
		 	model.addObject("hastaliktipi_id", hastalik_tipi_id);
		 	model.addObject("RandevuDetay", randevuService.getRandevu(randevu_no));
		 	

	        return model;
	    }
	 
		@RequestMapping(value = "/yorumeklemesayfasi")
	    public ModelAndView YorumEkle(@RequestParam("randevu_no") String randevu_no, 
	    		@RequestParam("hastaliktipiid") String hastalik_tipi_id, @RequestParam("icerik") String icerik_id, @RequestParam("bilgi_id") String bilgi_id ){
			
			
			ModelAndView model = new ModelAndView("yorum-ekle-sayfasi");
			
			Yorumlar yorumlar = new Yorumlar();
			model.addObject("yorumForm", yorumlar);
			model.addObject("icerik", icerik_id);
			model.addObject("bilgi_id", bilgi_id);
			model.addObject("hastaliktipiid", hastalik_tipi_id);
			model.addObject("randevu_no", randevu_no);
			model.addObject("yorumList", yorumlarService.getYorumlarList(randevu_no));
			model.addObject("getYorum", yorumlarService.getYorumlar(bilgi_id));
			
			
			
			
			
		return model;
			
			
			
	    }
	 
		@RequestMapping(value = "/yorumekle", method = RequestMethod.POST)
	    public String AddSummary(@ModelAttribute("yorumForm") Yorumlar yorumlar,@RequestParam("randevu_no") String randevu_no, 
	    		@RequestParam("hastaliktipiid") String hastalik_tipi_id, @RequestParam("icerik") String icerik_id, @RequestParam("bilgi_id") String bilgi_id  ){
			
			
			yorumlar.setBilgigirisi(hastaliktipiicerikService.getBilgiGirisi(bilgi_id));
			yorumlar.setRandevu(randevuService.getRandevu(randevu_no));
			hastaliktipiicerikService.YorumEkle(yorumlar);
			HastalikTipi hastaliktipi = hastaliktipiService.getHastalikTipi(hastalik_tipi_id);
			hastaliktipiService.addHastalikTipi(randevu_no, hastaliktipi);
			
	        return "redirect:../randevu/yorumeklemesayfasi?hastaliktipiid="+hastalik_tipi_id+"&randevu_no="+randevu_no+"&icerik="+icerik_id+"&bilgi_id="+bilgi_id;
	    }

	
	
}
