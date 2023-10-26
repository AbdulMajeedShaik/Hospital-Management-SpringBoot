package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
