package com.veterinaria.utils;

public class PetsCharacteristics {
    private String color;
    private String size;

    public PetsCharacteristics() {
    }

    public PetsCharacteristics(String color, String size) {
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
