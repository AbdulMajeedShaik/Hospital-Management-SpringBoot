package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models;

public class Patient {
    private String patientId;
    private String patientName;
    private String patientGender;
    private int patientAge;
    private String patientAddress;
    private String patientIllness;

    public Patient(String patientId, String patientName, String patientGender, int patientAge, String patientAddress, String patientIllness) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.patientAddress = patientAddress;
        this.patientIllness = patientIllness;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientIllness() {
        return patientIllness;
    }

    public void setPatientIllness(String patientIllness) {
        this.patientIllness = patientIllness;
    }
}
