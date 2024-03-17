package com.veterinaria.controller;

import com.veterinaria.connectionDB.ActionsDB;
import com.veterinaria.model.Pet;

import java.util.*;

public class PetController {
    private Set<Pet> listOfPets = new HashSet<>();
    ActionsDB actionsDB = new ActionsDB();
    public PetController() {
        List<String> data = actionsDB.selectAll("mascota");
        System.out.println(data);
        List<Pet> petsAux = new ArrayList<>();
        for (int i = 0; i < data.size(); i += 8) {
            long id = Integer.parseInt(data.get(i));
            long ownerId = Integer.parseInt(data.get(i + 1));
            String name = data.get(i + 2);
            int age = Integer.parseInt(data.get(i + 3));
            String breed = data.get(i + 4);
            String race = data.get(i + 5);
            float weight = Float.parseFloat(data.get(i + 6));
            String petCharacteristics = data.get(i + 7);
            Pet pet = new Pet(name, ownerId, age, id, breed, race, weight, petCharacteristics);
            petsAux.add(pet);
        }
        listOfPets.addAll(petsAux);
    }

    public Set<Pet> getAllPets() {
        return listOfPets;
    }

    public Pet findPetByID(int id) {
        for (Pet pet : listOfPets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    public void addPet(Pet pet) {
        listOfPets.add(pet);
        String[] columns = {"id", "propietario", "nombre", "edad", "raza", "especie", "peso", "caracteristicas"};
        String[] values = {String.valueOf(pet.getId()), String.valueOf(pet.getOwnerId()), pet.getName(), String.valueOf(pet.getAge()), pet.getBreed(), pet.getRace(), String.valueOf(pet.getWeight()), pet.getPetCharacteristics()};
        ActionsDB.insert("mascota", columns, values);
    }

    public void updatePet(Pet pet) {
        String[] columns = {"id", "propietario", "nombre", "edad", "raza", "especie", "peso", "caracteristicas"};
        String[] values = {String.valueOf(pet.getId()), String.valueOf(pet.getOwnerId()), pet.getName(), String.valueOf(pet.getAge()), pet.getBreed(), pet.getRace(), String.valueOf(pet.getWeight()), pet.getPetCharacteristics()};
        String condition = "id = " + pet.getId();
        actionsDB.update("mascota", columns, values, condition);
    }

}
