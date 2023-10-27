package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.*;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public void addDocToDataBase(Doctor obj){
        String docId = "Doctor" + (doctorRepository.getOverAllDoctors()+1);
        obj.setDocId(docId);
        doctorRepository.addDocToDataBase(obj);
    }

    public Doctor getDocById(String docId){
      return doctorRepository.getDocById(docId);
    }

    public int totalDoctors(){
        return doctorRepository.totalDoctors();
    }

    public int getOverAllDoctors(){
        return doctorRepository.getOverAllDoctors();
    }

    public void updateDocDetailsByDocId(String docId,Doctor obj){
        doctorRepository.updateDocDetailsByDocId(docId,obj);
    }

    public ArrayList<Patient> getAllPatients(String docId){
        return doctorRepository.getAllPatients(docId);
    }
    public Doctor getMinimumDoctorPatient(){
        int min = Integer.MAX_VALUE;
        Doctor obj = null;

        HashMap<String, ArrayList<Patient>> patients = doctorRepository.getDocVsPatient();
        for(String key : patients.keySet()){
           ArrayList<Patient> doctorsPatients = patients.get(key);
           int totalPatients = doctorsPatients.size();
           if(totalPatients<min){
               min = totalPatients;
               obj = doctorRepository.getDocById(key);
           }
        }
        return obj;
    }
}
