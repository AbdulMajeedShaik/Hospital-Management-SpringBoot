package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DoctorRepository {
    private HashMap<String,Doctor> docDataBase;
    private int overAllDoctors;

    public DoctorRepository(){
      this.overAllDoctors = 0;
      this.docDataBase = new HashMap<>();
    }

    public void addDocToDataBase(Doctor obj){
        this.overAllDoctors += 1;
        docDataBase.put(obj.getDocId(), obj);
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
