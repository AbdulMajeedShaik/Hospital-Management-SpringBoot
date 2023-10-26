package com.hospitalmanagement.backend.Hospital.Management.System.Backend.Models;

public class Doctor {
    private String docId;
    private String docName;
    private String docDegree;
    private String docGender;

    public Doctor(String docId, String docName, String docDegree, String docGender) {
        this.docId = docId;
        this.docName = docName;
        this.docDegree = docDegree;
        this.docGender = docGender;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocDegree() {
        return docDegree;
    }

    public void setDocDegree(String docDegree) {
        this.docDegree = docDegree;
    }

    public String getDocGender() {
        return docGender;
    }

    public void setDocGender(String docGender) {
        this.docGender = docGender;
    }
}
