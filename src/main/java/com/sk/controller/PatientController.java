package com.sk.controller;

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

import com.sk.model.Patient;
import com.sk.services.PatientService;

@Controller
@Transactional
@RequestMapping("/patient")
public class PatientController {
	
		@Autowired
	    PatientService personService;
	
		
		@RequestMapping(method = RequestMethod.GET)
		public String printWelcome(Map<String,Object> model) {
	      
	        
		    Patient person=new Patient();
	        model.put("personForm", person);
	        model.put("listPerson", personService.getPatientList());

	     
			return "hello";
		}
		
		
		@RequestMapping(method = RequestMethod.POST)
	    public String save(@ModelAttribute("personForm") Patient patient){
		 	personService.insertData(person);
	        return "redirect:person";
	    }

		@RequestMapping(value = "/delete",method = RequestMethod.GET)
	    public String deleteUser(@RequestParam String id){
			personService.deletePatient(id);
	        return "redirect:/person";
	    }
		
		 @RequestMapping(value = "/edit")
		    public ModelAndView editPerson(@RequestParam String id){
			  	ModelAndView model = new ModelAndView("edit");
		        Patient person = personService.getPatient(id);
		        model.addObject("listPerson", personService.getPatientList());
		        model.addObject("personForm", person);
		        return model;
		    }
		
		 @RequestMapping(value = "/update", method = RequestMethod.POST)
		    public String update(@ModelAttribute("personForm") Patient person) {	 
			 personService.updatePerson(person);	        
		        return "redirect:/person";    
		    }
		  
	


}
