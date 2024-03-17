package com.veterinaria.controller;

import com.veterinaria.connectionDB.ActionsDB;
import com.veterinaria.model.Person;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    // Lista de todas las personas
    private final Set<Person> listOfPersons = new HashSet<>();
    public static Person currentPerson;
    public UserController() {
        ActionsDB actionsDB = new ActionsDB();
        List<String> data = actionsDB.selectAll("persona");
        try {
            for (int i = 0; i < data.size(); i += 6) {
                int id = Integer.parseInt(data.get(i));
                String name = data.get(i + 1);
                int age = Integer.parseInt(data.get(i + 2));
                String role = data.get(i + 3);
                String username = data.get(i + 4);
                String password = data.get(i + 5);
                listOfPersons.add(new Person(id, name, age, role, username, password));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Person findPerson(String username, String password) {
        for (Person person : listOfPersons) {
            if (person.getUsername().equals(username) && person.getPassword().equals(password)) {
                return person;
            }
        }
        return null;
    }

    public Person findPersonByID(long id) {
        for (Person person : listOfPersons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public Set<Person> getAllPersons() {
        return listOfPersons;
    }

    public void updatePersonByID(long id, String name, int age, String role, String username, String password) {
        for (Person person : listOfPersons) {
            if (person.getId() == id) {
                person.setName(name);
                person.setAge(age);
                person.setRole(role);
                person.setUsername(username);
                person.setPassword(password);
            }
        }
        // Actualizamos el usuario en la base datos
        ActionsDB.update("persona", new String[]{"cedula","nombre", "edad", "rol", "username", "password"}, new String[]{String.valueOf(id),name, String.valueOf(age), role, username, password}, "cedula = " + id);
    }

    public void deletePersonByID(long id) {
        for (Person person : listOfPersons) {
            if (person.getId() == id) {
                listOfPersons.remove(person);
                return;
            }
        }
    }

    public void showAllPersons() {
        for (Person person : listOfPersons) {
            System.out.println(person);
        }
    }

    public Person savePersonClient(long id, String name, int age, String role) {
        // tabla, [columnas], [valores]
        ActionsDB.insert("persona", new String[]{"cedula","nombre", "edad", "rol", "username", "password"}, new String[]{String.valueOf(id), name, String.valueOf(age), role, "", ""});

        Person person = new Person(id, name, age, role);
        listOfPersons.add(person);
        return person;
    }

    public void savePerson(long id, String name, int age, String role, String username, String password) {
        Person person = new Person(id,name, age, role, username, password);
        listOfPersons.add(person);

        // Guardamos el usuario en la base datos
        ActionsDB.insert("persona", new String[]{"cedula","nombre", "edad", "rol", "username", "password"}, new String[]{String.valueOf(id), name, String.valueOf(age), role, username, password});
    }

    public void setCurrentPerson(Person person) {
        currentPerson = person;
    }

}
