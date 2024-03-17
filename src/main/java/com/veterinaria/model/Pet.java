package com.veterinaria.model;

public class Pet {
    private String name;
    private long ownerId;
    private int age;
    private long id;
    private String breed;
    private String race;
    private float weight;
    private String petCharacteristics;

    public Pet() {
    }

    public Pet(String name, long ownerId, int age, long id, String breed, String race, float weight, String petCharacteristics) {
        this.name = name;
        this.ownerId = ownerId;
        this.age = age;
        this.id = id;
        this.breed = breed;
        this.race = race;
        this.weight = weight;
        this.petCharacteristics = petCharacteristics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getPetCharacteristics() {
        return petCharacteristics;
    }

    public void setPetCharacteristics(String petCharacteristics) {
        this.petCharacteristics = petCharacteristics;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", ownerId=" + ownerId +
                ", age=" + age +
                ", id=" + id +
                ", breed='" + breed + '\'' +
                ", race='" + race + '\'' +
                ", weight=" + weight +
                ", petCharacteristics='" + petCharacteristics + '\'' +
                '}';
    }
}
