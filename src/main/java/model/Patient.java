package model;

import java.time.LocalDateTime;

public class Patient {
    private String patientId;
    private String fullName;
    private String documentId;
    private int age;
    private char gender;
    private String email;
    private LocalDateTime registrationDate;
    private String clinicalNotes;
    private String checksumFasta;
    private long fileSizeBytes;
    private boolean active;

    public Patient(String fullName, String documentId, int age, char gender, String email, String clinicalNotes, String checksumFasta, long fileSizeBytes) {
        this.fullName = fullName;
        this.documentId = documentId;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.clinicalNotes = clinicalNotes;
        this.checksumFasta = checksumFasta;
        this.fileSizeBytes = fileSizeBytes;
        this.registrationDate = LocalDateTime.now();
        this.active = true;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getClinicalNotes() {
        return clinicalNotes;
    }

    public void setClinicalNotes(String clinicalNotes) {
        this.clinicalNotes = clinicalNotes;
    }

    public String getChecksumFasta() {
        return checksumFasta;
    }

    public void setChecksumFasta(String checksumFasta) {
        this.checksumFasta = checksumFasta;
    }

    public long getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(long fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
