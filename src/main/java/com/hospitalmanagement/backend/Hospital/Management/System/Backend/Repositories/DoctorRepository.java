package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class DoctorRepository {
    private HashMap<String,Doctor> docDataBase;
    private HashMap<String, ArrayList<Patient>> docVsPatient;
    private int overAllDoctors;

    public DoctorRepository(){
      this.overAllDoctors = 0;
      this.docDataBase = new HashMap<>();
      this.docVsPatient = new HashMap<>();
    }

    public void addDocToDataBase(Doctor obj){
        this.overAllDoctors += 1;
        this.docVsPatient.put(obj.getDocId(),new ArrayList<>());
        docDataBase.put(obj.getDocId(), obj);
    }

    public HashMap<String,ArrayList<Patient>> getDocVsPatient(){
        return docVsPatient;
    }
    public void assignPatientToDoctor(String docId,Patient obj){
        ArrayList<Patient> patients = this.docVsPatient.get(docId);
        patients.add(obj);
    }

    public ArrayList<Patient> getAllPatients(String docId){
        return docVsPatient.get(docId);
    }
    public Doctor getDocById(String docId){
        return docDataBase.get(docId);
    }

    public int totalDoctors(){
        return docDataBase.size();
    }

    public int getOverAllDoctors(){
        return this.overAllDoctors;
    }

    public void updateDocDetailsByDocId(String docId,Doctor obj){
        this.docDataBase.put(docId,obj);
    }
}
