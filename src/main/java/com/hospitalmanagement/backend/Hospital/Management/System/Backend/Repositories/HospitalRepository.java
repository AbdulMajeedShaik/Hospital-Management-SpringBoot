package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository {

    private Patient[] beds;

    private final int bedFee = 500;

    public HospitalRepository() {
        this.beds = new Patient[500];
    }

    public void assignPatientByBedNumber(int bedNumber, Patient obj) {
        beds[bedNumber] = obj;
    }

    public Patient getPatientByParticularBedNumber(int bedNumber) {
        return beds[bedNumber];
    }

    public Patient[] getAllBeds(){
         return beds;
    }

    public int getBedFee(){
        return bedFee;
    }

    public void deAllocateBed(String pId){

        for(int i=0;i<beds.length;i++){
            if(beds[i]!=null){
                Patient obj = beds[i];
                if(obj.getPatientId().equals(pId)){
                    beds[i] = null;
                    break;
                }
            }
        }
    }
}
