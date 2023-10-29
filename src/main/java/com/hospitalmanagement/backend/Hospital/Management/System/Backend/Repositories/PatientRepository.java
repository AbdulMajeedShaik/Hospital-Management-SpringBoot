package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import org.springframework.stereotype.Repository;
import java.util.HashMap;

@Repository
public class PatientRepository {
    private HashMap<String, Patient> patientDataBase;
    private HashMap<String, Doctor> patientVsDoctor;

    private int overAllPatients;

    public PatientRepository() {
        this.patientVsDoctor = new HashMap<>();
        this.overAllPatients = 0;
        this.patientDataBase = new HashMap<>();
    }

    public void assignDoctorToPatient(String patientId,Doctor obj){
        this.patientVsDoctor.put(patientId,obj);
    }
    public Patient getPatientById(String patientId){
        return patientDataBase.get(patientId);
    }
    public void addPatientToDataBase(Patient obj){
        this.overAllPatients += 1;
        patientDataBase.put(obj.getPatientId(), obj);
    }

    public Doctor getPatientsDoctor(String pId){
        return patientVsDoctor.get(pId);
    }

    public void dischargePatientById(String patientId){
        patientVsDoctor.remove(patientId);
        patientDataBase.remove(patientId);
    }

    public int totalPatients(){
        return patientDataBase.size();
    }

    public int getOverAllPatients(){
        return this.overAllPatients;
    }



}
