package com.sk.dao;

import java.util.List;

import com.sk.model.Patient;

public interface PatientDao {
	
	  	public List<Patient> getPatientList();
	  	public void delete(String id);
	    public void insertData(Patient patient);
	    public void updatePatient(Patient patient);
	    public Patient getPatient(String id);
	   
}
