package com.sk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.dao.PatientDao;
import com.sk.model.Patient;
import com.sk.model.Sehir;


@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
    PatientDao personDao;
  
//	public void setPersonDao(PersonDao personDao) {
//		this.personDao = personDao;
//	}
	
	@Override
	@Transactional
	public List<Patient> getPatientList() {
		
		
		return personDao.getPatientList();
	}

	@Override
	public void deletePatient(String id) {
		personDao.delete(id);
		
	}

	@Override
	public void insertData(Patient patient) {
		personDao.insertData(patient);
		
	}

	@Override
	public void updatePatient(Patient patient) {
		personDao.updatePatient(patient);
		
	}

	@Override
	public Patient getPatient(String id) {
		return personDao.getPatient(id);
	}

	@Override
	public List<Sehir> getSehirList() {
		// TODO Auto-generated method stub
		return personDao.getSehirList();
	}


}
