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
    PatientDao patientDao;
  
//	public void setPersonDao(PersonDao personDao) {
//		this.personDao = personDao;
//	}
	
	@Override
	@Transactional
	public List<Patient> getPatientList() {
		
		
		return patientDao.getPatientList();
	}

	@Override
	public void deletePatient(String id) {
		patientDao.delete(id);
		
	}

	@Override
	public void insertData(Patient patient) {
		patientDao.insertData(patient);
		
	}

	@Override
	public void updatePatient(Patient patient) {
		patientDao.updatePatient(patient);
		
	}

	@Override
	public Patient getPatient(String id) {
		return patientDao.getPatient(id);
	}

	@Override
	public List<Sehir> getSehirList() {
		return patientDao.getSehirList();
	}

	@Override
	public List<Patient> getPatientList(int page_baslangic_id, int total) {
		// TODO Auto-generated method stub
		return patientDao.getPatientList(page_baslangic_id, total);
	}




}
