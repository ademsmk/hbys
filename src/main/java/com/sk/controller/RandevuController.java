package com.sk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sk.dto.PatientDTO;
import com.sk.model.Patient;
import com.sk.services.PatientService;
import com.sk.services.RandevuService;

@Controller
@Transactional
@RequestMapping("/randevu")
public class RandevuController {
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	RandevuService randevuService;
	
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
	
	
}
