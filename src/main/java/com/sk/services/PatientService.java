package com.sk.services;

import java.util.List;

import com.sk.model.Patient;



public interface PatientService {

  
    public List<Patient> getPatientList();
    public void deletePatient(String id);
    public void insertData(Patient patient);
    public void updatePatient(Patient patient);
    public Patient getPatient(String id);
    

}
