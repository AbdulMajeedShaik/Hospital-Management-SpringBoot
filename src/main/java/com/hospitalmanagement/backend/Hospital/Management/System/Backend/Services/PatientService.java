package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Services;

import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Bill;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Doctor;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models.Patient;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories.DoctorRepository;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories.HospitalRepository;
import com.hospitalmanagement.backend.Hospital.Management.System.Backend.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    HospitalService hospitalService;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepo;
    @Autowired
    DoctorService doctorService;

    public Patient getPatientById(String patientId){
        return patientRepo.getPatientById(patientId);
    }
    public void addPatientToDataBase(Patient obj){
       String patientId = "Patient"+(patientRepo.getOverAllPatients()+1);
       obj.setPatientId(patientId);
       int bedNumber = hospitalService.getFirstEmptyBed();
       hospitalService.assignPatientByBedNumber(bedNumber,obj);
       Doctor doc = doctorService.getMinimumDoctorPatient();
       patientRepo.assignDoctorToPatient(patientId,doc);
       doctorRepository.assignPatientToDoctor(doc.getDocId(),obj);
       patientRepo.addPatientToDataBase(obj);
    }

    public Doctor getPatientsDoctor(String pId){
        return patientRepo.getPatientsDoctor(pId);
    }
    public Bill dischargePatientById(String pId,String dischargeDate){
         Patient obj = patientRepo.getPatientById(pId);
         String admitDate = obj.getAdmitDate();
         String[] admitDateArray = admitDate.split("-");
         String[] dischargeDateArray = dischargeDate.split("-");
         int diff = Integer.parseInt(dischargeDateArray[0])-Integer.parseInt(admitDateArray[0]);
         Doctor docObj = patientRepo.getPatientsDoctor(pId);
         int docBill = docObj.getDocFee();
         int bedBill = hospitalService.getBedFee();
         int totalBill = diff*(docBill+bedBill);
         Bill billObj = new Bill(docBill,bedBill,totalBill);
         patientRepo.dischargePatientById(pId);
         doctorRepository.removeParticularPatientForParticularDoctor(docObj.getDocId(),pId);
         hospitalService.deAllocateBed(pId);
         return billObj;
    }

}
