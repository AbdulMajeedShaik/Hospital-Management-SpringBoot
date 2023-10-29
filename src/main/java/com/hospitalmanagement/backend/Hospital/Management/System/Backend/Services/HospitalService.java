package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;
    public int getFirstEmptyBed(){
       Patient[] beds = hospitalRepository.getAllBeds();
       for(int i=0;i<beds.length;i++){
           if(beds[i]==null){
               return i;
           }
       }
       return -1;
    }

    public Patient getPatientFromBedNumber(int bedNumber){
        return hospitalRepository.getPatientByParticularBedNumber(bedNumber);
    }

    public void assignPatientByBedNumber(int bedNumber, Patient obj) {
        hospitalRepository.assignPatientByBedNumber(bedNumber,obj);
    }
    public int getBedFee(){
        return hospitalRepository.getBedFee();
    }
}
