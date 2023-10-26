package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import org.springframework.stereotype.Repository;
import java.util.HashMap;

@Repository
public class PatientRepository {
    private HashMap<String, Patient> patientDataBase;

    private int overAllPatients;

    public PatientRepository() {
        this.overAllPatients = 0;
        this.patientDataBase = new HashMap<>();
    }

    public Patient getPatientById(String patientId){
        return patientDataBase.get(patientId);
    }
    public void addPatientToDataBase(Patient obj){
        this.overAllPatients += 1;
        patientDataBase.put(obj.getPatientId(), obj);
    }

    public void dischargePatientById(String patientId){
        patientDataBase.remove(patientId);
    }

    public int totalPatients(){
        return patientDataBase.size();
    }

    public int getOverAllPatients(){
        return this.overAllPatients;
    }


}
