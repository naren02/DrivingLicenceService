package com.example.dl.model;

import java.time.LocalDate;

public class LicenseApplication {

    private String applicantId;
    private LocalDate dateOfBirth;
    private boolean learnerPermit;
    private boolean theoryTestPassed;
    private boolean drivingTestPassed;
    private int trafficViolationsLastYear;
    private boolean medicallyFit;

    // Results set by Drools
    private boolean eligible;
    private String rejectionReason;

    public int getAge() {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isLearnerPermit() {
        return learnerPermit;
    }

    public void setLearnerPermit(boolean learnerPermit) {
        this.learnerPermit = learnerPermit;
    }

    public boolean isTheoryTestPassed() {
        return theoryTestPassed;
    }

    public void setTheoryTestPassed(boolean theoryTestPassed) {
        this.theoryTestPassed = theoryTestPassed;
    }

    public boolean isDrivingTestPassed() {
        return drivingTestPassed;
    }

    public void setDrivingTestPassed(boolean drivingTestPassed) {
        this.drivingTestPassed = drivingTestPassed;
    }

    public int getTrafficViolationsLastYear() {
        return trafficViolationsLastYear;
    }

    public void setTrafficViolationsLastYear(int trafficViolationsLastYear) {
        this.trafficViolationsLastYear = trafficViolationsLastYear;
    }

    public boolean isMedicallyFit() {
        return medicallyFit;
    }

    public void setMedicallyFit(boolean medicallyFit) {
        this.medicallyFit = medicallyFit;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    // Getters & setters omitted for brevity
}
