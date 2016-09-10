package com.sk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.sk.dto.PatientDTO;
import com.sk.model.HastalikTipi;
import com.sk.model.Patient;
import com.sk.model.Randevu;
import com.sk.services.PatientService;
import com.sk.services.RandevuService;

@Controller
@Transactional
@RequestMapping("/patient")
public class PatientController {
	
		@Autowired
	    PatientService patientService;
		
		@Autowired
		RandevuService randevuService;
	
		
		@RequestMapping(method = RequestMethod.GET)
		public String printWelcome(Map<String,Object> model) {
	      
	        
		    Patient patient=new Patient();
	        model.put("patientForm", patient);
	        model.put("SehirlerListesi", patientService.getSehirList());

			return "hasta-kayit";
		}
		
		@RequestMapping(value = "/kayitlihastalar", method = RequestMethod.GET)
		public String Hastalar(Map<String,Object> model, @RequestParam("page_id") int page ) {
			
			int recordsPerPage  = 5;
//				if(page == 1){
//					List<Patient> list1 = patientService.getPatientList();
//					int noOfRecords  = list1.size();
//					int noOfPages  = (int) Math.ceil(noOfRecords*1.0 / recordsPerPage);
//					List<Patient> list = patientService.getPatientList((page-1)*recordsPerPage, recordsPerPage);
//					
//					model.put("HastaListesi", list);
//					model.put("noOfPages", noOfPages);
//					model.put("currentPage", page);
//				}
//				else{
//					List<Patient> list1 = patientService.getPatientList();
//					int noOfRecords  = list1.size();
//					int noOfPages  = (int) Math.ceil(noOfRecords*1.0 / recordsPerPage);
//					List<Patient> list = patientService.getPatientList((page-1)*recordsPerPage, recordsPerPage);
//					
//					model.put("HastaListesi", list);
//					model.put("noOfPages", noOfPages);
//					model.put("currentPage", page);
//				}
    
//			List<Patient> list = patientService.getPatientList((page_id-1), total);
//		
//			
//			model.put("HastaListesi", list);
//			model.put("page_id", page_id);
			
			List<Patient> list1 = patientService.getPatientList();
			int noOfRecords  = list1.size();
			int noOfPages  = (int) Math.ceil(noOfRecords*1.0 / recordsPerPage);
			List<Patient> list = patientService.getPatientList((page-1)*recordsPerPage, recordsPerPage);
			
			model.put("HastaListesi", list);
			model.put("noOfPages", noOfPages);
			model.put("currentPage", page);
			
	        model.put("patientForm", new Patient());
			return "hastalar";
		}
		 
		 @RequestMapping(value = "/search", method = RequestMethod.POST)
		    public String deneme(@ModelAttribute("patientForm") Patient patient){
			  	String id = Integer.toString(patient.getDosya_no());
		        return "redirect:../patient/hastadetay?id="+id;
		 }
		 
		 @RequestMapping(value = "/hastadetay")
		    public ModelAndView HastaDetay(@RequestParam String id){
			  	ModelAndView model = new ModelAndView("hasta-detay");
		        model.addObject("HastaDetay", patientService.getPatient(id));
		        return model;
		    }
		

		@RequestMapping(method = RequestMethod.POST)
	    public String save(@ModelAttribute("patientForm") Patient patient){
			patientService.insertData(patient);
	        return "redirect:patient";
	    }

		@RequestMapping(value = "/delete",method = RequestMethod.GET)
	    public String deleteUser(@RequestParam String id){
			patientService.deletePatient(id);
	        return "redirect:../patient/kayitlihastalar?page_id=1";
	    }
		
		 @RequestMapping(value = "/edit")
		    public ModelAndView editPerson(@RequestParam String id){
			  	ModelAndView model = new ModelAndView("hasta-edit");
		        Patient patient = patientService.getPatient(id); 
		        model.addObject("SehirlerListesi", patientService.getSehirList());
		        model.addObject("patientForm", patient);
		        return model;
		    }
		
		 @RequestMapping(value = "/update", method = RequestMethod.POST)
		    public String update(@ModelAttribute("patientForm") Patient patient) {	
			 int id = patient.getDosya_no();
			 patientService.updatePatient(patient);	        
		        return "redirect:../patient/hastadetay?id="+id;    
		    }
		  
		 @RequestMapping(value = "/randevular")
		    public ModelAndView ShowAuthorBooks(@RequestParam String id){
			  	ModelAndView model = new ModelAndView("hasta-randevu");        
		        Patient hasta = patientService.getPatient(id);
		        List<PatientDTO> patientDTO = new ArrayList<PatientDTO>();

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
		    	 
		        model.addObject("hastalar", patientDTO);
		        model.addObject("randevuForm", new Randevu());
		        model.addObject("dosya_no",id);
		        
		        
		        return model;
		    }
		 


}
