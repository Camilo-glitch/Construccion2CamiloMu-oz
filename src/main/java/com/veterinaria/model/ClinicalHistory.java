package com.veterinaria.model;

public class ClinicalHistory {
    private long date;
    private long veterinarian;
    private String reason;
    private String symptoms;
    private String diagnosis;
    private String procedure;
    private String medication;
    private String dose;
    private String idOrder;
    private String allergy;
    private String procedureDetail;
    private boolean orderCancellation;

    public ClinicalHistory() {
    }

    public ClinicalHistory(long date, long veterinarian, String reason, String symptoms, String diagnosis, String procedure, String medication, String dose, String idOrder, String allergy, String procedureDetail, boolean orderCancellation) {
        this.date = date;
        this.veterinarian = veterinarian;
        this.reason = reason;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.procedure = procedure;
        this.medication = medication;
        this.dose = dose;
        this.idOrder = idOrder;
        this.allergy = allergy;
        this.procedureDetail = procedureDetail;
        this.orderCancellation = orderCancellation;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getProcedureDetail() {
        return procedureDetail;
    }

    public void setProcedureDetail(String procedureDetail) {
        this.procedureDetail = procedureDetail;
    }

    public boolean isOrderCancellation() {
        return orderCancellation;
    }

    public void setOrderCancellation(boolean orderCancellation) {
        this.orderCancellation = orderCancellation;
    }

    public long getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(long veterinarian) {
        this.veterinarian = veterinarian;
    }
}
