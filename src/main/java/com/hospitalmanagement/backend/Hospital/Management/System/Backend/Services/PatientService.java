package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepo;

    public Patient getPatientById(String patientId){
        return patientRepo.getPatientById(patientId);
    }
    public void addPatientToDataBase(Patient obj){
       String patientId = "Patient"+(patientRepo.getOverAllPatients()+1);
       obj.setPatientId(patientId);
       patientRepo.addPatientToDataBase(obj);
    }

    public void dischargePatientById(String patientId){
      patientRepo.dischargePatientById(patientId);
    }
}
