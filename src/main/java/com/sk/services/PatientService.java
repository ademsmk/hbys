package com.sk.services;

import java.util.List;

import com.sk.model.Patient;
import com.sk.model.Sehir;



public interface PatientService {

  
    public List<Patient> getPatientList();
    public void deletePatient(String id);
    public void insertData(Patient patient);
    public void updatePatient(Patient patient);
    public Patient getPatient(String id);
    public List<Sehir> getSehirList();
    public List<Patient> getPatientList(int page_baslangic_id, int total);

    

}
