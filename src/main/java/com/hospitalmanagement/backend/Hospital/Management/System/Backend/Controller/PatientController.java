package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Controller;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/api/patient")
    public Patient getPatientById(@RequestParam String patientId){
        return patientService.getPatientById(patientId);
    }

    @PostMapping("/api/patient/addpatient")
    public String addPatientToDataBase(@RequestBody Patient obj){
       patientService.addPatientToDataBase(obj);
       return "Patient got added successfully into database";
    }

    @DeleteMapping("/api/patient")
    public String dischargePatientById(@RequestParam String patientId){
       patientService.dischargePatientById(patientId);
       return "Patient got deleted successfully from database";
    }
}
