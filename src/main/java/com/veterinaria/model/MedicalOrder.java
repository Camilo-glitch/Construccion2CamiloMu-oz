package com.veterinaria.model;

public class MedicalOrder {
    /*
    -id orden debe ser único
- id mascota
-cedula dueño
-cedula veterinario que ordena
- nombre medicamento dosis
-fecha de generación (fecha en la que se registra en la historia clinica)

    */
    private long orderId;
    private long petId;
    private long ownerId;
    private long veterinarianId;
    private String medicationName;
    private String dose;
    private String generationDate;

    public MedicalOrder() {
    }

    public MedicalOrder(long orderId, long petId, long ownerId, long veterinarianId, String medicationName, String dose, String generationDate) {
        this.orderId = orderId;
        this.petId = petId;
        this.ownerId = ownerId;
        this.veterinarianId = veterinarianId;
        this.medicationName = medicationName;
        this.dose = dose;
        this.generationDate = generationDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public long getVeterinarianId() {
        return veterinarianId;
    }

    public void setVeterinarianId(long veterinarianId) {
        this.veterinarianId = veterinarianId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(String generationDate) {
        this.generationDate = generationDate;
    }
}
