package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Controller;


import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("/api/doctor")
    public Doctor getDocById(@RequestParam String git stat){
        return doctorService.getDocById(docId);
    }

    @PostMapping("/api/doctor/adddoctor")
    public String addDoctorToDataBase(@RequestBody Doctor obj){
       doctorService.addDocToDataBase(obj);
        return "Doctor got added successfully into database";
    }


    @PutMapping("/api/doctor")
    public String updateDocDetailsByDocId(@RequestParam String docId,@RequestBody Doctor obj){
         doctorService.updateDocDetailsByDocId(docId,obj);
         return "doc details with docId this "+docId+" got updated";
    }

}
