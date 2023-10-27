package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository {

    private Patient[] beds;

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
}
