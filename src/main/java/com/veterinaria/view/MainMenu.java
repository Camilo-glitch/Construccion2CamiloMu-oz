package com.veterinaria.view;

import com.veterinaria.controller.ClinicalHistoryController;
import com.veterinaria.controller.PetController;
import com.veterinaria.controller.UserController;
import com.veterinaria.model.ClinicalHistory;
import com.veterinaria.model.Person;
import com.veterinaria.model.Pet;
import com.veterinaria.utils.Role;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainMenu {
    private int optionSelectedByUser = 0;
    private Scanner sc = new Scanner(System.in);

    // Usuarios
    private final Person currentPerson = UserController.currentPerson;
    private final UserController userController = new UserController();

    // Mascotas
    private final Pet pet = new Pet();
    private final PetController pe = new PetController();

    // Historia clínica
    private  final ClinicalHistory clinicalHistory = new ClinicalHistory();
    private final ClinicalHistoryController clHistoryController = new ClinicalHistoryController();
    public MainMenu() {
        showMenu();
    }

    public int showMenu() {
        System.out.println("""
                --- MENÚ PRINCIPAL ---
                1. Usuarios.
                2. Mascotas.
                3. Historia clínica.
                4. Facturas de venta.
                5. Salir.
                
                Elija una opción:
                """);
        try {
            optionSelectedByUser = sc.nextInt();
            if (optionSelectedByUser < 1 || optionSelectedByUser > 4) {
                throw new Exception("Error: Debe ingresar un número entre 1 y 4");
            } else {
                showMenuOptions();
            }
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un número entero");
        }
        return optionSelectedByUser;
    }

    private void showMenuOptions() {

        switch (optionSelectedByUser) {
            case 1 -> users();
            case 2 -> pets();
            case 3 -> clinicalHistory();
            case 4 -> System.out.println("Opción no implementada");
            case 5 -> System.exit(0);
        }
    }

    // Operaciones con usuarios
    public void users(){
        System.out.println("""
                --- MENÚ USUARIOS ---
                
                (Si usted no cuenta con permisos de administrador, sólo podrá listar los usuarios)
                
                1. Crear usuario
                2. Modificar usuario
                3. Listar usuarios
                4. Volver al menú principal
                
                Elija una opción:
                """);
        try {
            optionSelectedByUser = sc.nextInt();
            if (optionSelectedByUser < 1 || optionSelectedByUser > 5) {
                throw new Exception("Error: Debe ingresar un número entre 1 y 5");
            } else {
                showUsersOptions();
            }
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un número entero" + e.toString());
        }
    }

    private void showUsersOptions() {
       if (currentPerson.getRole().toUpperCase().equals(Role.ADMIN.toString())) {
           switch (optionSelectedByUser) {
               case 1 -> {
                   System.out.print("ID: ");
                   long id = sc.nextLong();
                   System.out.print("Nombre: ");
                   String name = sc.next();
                   System.out.print("Edad: ");
                   int age = sc.nextInt();
                   System.out.println("Los roles disponibles son: " + Role.ADMIN + " y " + Role.VET + " y " + Role.CLIENT + "Elija uno: ");
                   String role = sc.next();
                   System.out.print("Usuario: ");
                   String username = sc.next();
                   System.out.print("Contraseña: ");
                   String password = sc.next();
                   try {
                       userController.savePerson(id, name, age, role, username, password);
                       System.out.println("Usuario creado con éxito");
                       users();
                   } catch (Exception e) {
                       System.out.println("Error al crear usuario: " + e);
                   }
               }
               case 2 -> {
                   System.out.print("ID Del usuario a modificar: ");
                   long id = sc.nextLong();
                   System.out.println("Modificando al usuario: " + userController.findPersonByID(id));
                   System.out.print("Nombre: ");
                   String name = sc.next();
                   System.out.print("Edad: ");
                   int age = sc.nextInt();
                   System.out.println("Los roles disponibles son: " + Role.ADMIN + " y " + Role.VET + " y " + Role.CLIENT + " Elija uno: ");
                   System.out.print("Rol: ");
                   String role = sc.next();
                   System.out.print("Usuario: ");
                   String username = sc.next();
                   System.out.print("Contraseña: ");
                   String password = sc.next();
                   try {
                       userController.updatePersonByID(id, name, age, role, username, password);
                       System.out.println("Usuario con ID " + id + " modificado con éxito" + "Usuario= " + userController.findPersonByID(id));
                       users();

                   } catch (Exception e) {
                       System.out.println("Error al modificar usuario: " + e);
                   }
               }
                case 3 -> {
                     userController.showAllPersons();
                     users();
                }
                case 4 -> showMenu();
           }
       } else {
           System.out.println("Menu sin permisos de administrador");
           System.out.println("Elija una opción: 4. Listar usuarios o 5. Volver al menú principal");
           optionSelectedByUser = sc.nextInt();
           switch (optionSelectedByUser) {
               case 4 -> {
                   userController.showAllPersons();
                   showMenuOptions();
               }
               case 5 -> showMenu();
           }
       }
    }

    // Operaciones con mascotas
    public void pets() {
        System.out.println("""
                --- MENÚ MASCOTAS ---
                (Si usted no cuenta con permisos de administrador o veterinario, sólo podrá listar las mascotas)
                1. Agregar mascota
                2. Modificar mascota
                3. Listar mascotas
                4. Volver al menú principal
                
                Elija una opción:
                """);
        try {
            optionSelectedByUser = sc.nextInt();
            if (optionSelectedByUser < 1 || optionSelectedByUser > 4) {
                throw new Exception("Error: Debe ingresar un número entre 1 y 4");
            } else {
                showPetsOptions();
            }
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un número entero");
        }
    }

    private void showPetsOptions() {
        if (currentPerson.getRole().toUpperCase().equals(Role.ADMIN.toString()) || currentPerson.getRole().toUpperCase().equals(Role.VET.toString())) {
            switch (optionSelectedByUser) {
                case 1 -> {
                    System.out.print("ID: ");
                    long id = sc.nextLong();
                    System.out.print("ID del propietario: ");
                    long ownerId = sc.nextLong();
                    System.out.print("Nombre: ");
                    String name = sc.next();
                    System.out.print("Edad: ");
                    int age = sc.nextInt();
                    System.out.print("Raza: ");
                    String breed = sc.next();
                    System.out.print("Especie: ");
                    String race = sc.next();
                    System.out.print("Peso: ");
                    float weight = sc.nextFloat();
                    System.out.print("Características: ");
                    String petCharacteristics = sc.next();
                    try {
                        pe.addPet(new Pet(name, ownerId, age, id, breed, race, weight, petCharacteristics));
                        System.out.println("Mascota creada con éxito");
                        pets();
                    } catch (Exception e) {
                        System.out.println("Error al crear mascota: " + e);
                    }
                }
                case 2 -> {
                    System.out.print("ID de la mascota a modificar: ");
                    long id = sc.nextLong();
                    System.out.println("Modificando a la mascota: " + pe.findPetByID((int) id));
                    System.out.print("ID del propietario: ");
                    long ownerId = sc.nextLong();
                    System.out.print("Nombre: ");
                    String name = sc.next();
                    System.out.print("Edad: ");
                    int age = sc.nextInt();
                    System.out.print("Raza: ");
                    String breed = sc.next();
                    System.out.print("Especie: ");
                    String race = sc.next();
                    System.out.print("Peso: ");
                    float weight = sc.nextFloat();
                    System.out.print("Características: ");
                    String petCharacteristics = sc.next();
                    try {
                        pe.updatePet(new Pet(name, ownerId, age, id, breed, race, weight, petCharacteristics));
                        System.out.println("Mascota con ID " + id + " modificada con éxito" + "Mascota= " + pe.findPetByID((int) id));
                        pets();
                    } catch (Exception e) {
                        System.out.println("Error al modificar mascota: " + e);
                    }
                }
                case 3 -> {
                    pe.getAllPets().forEach(System.out::println);
                    pets();
                }
                case 4 -> showMenu();
            }
        } else {
            System.out.println("Menu sin permisos de administrador o veterinario");
            System.out.println("""
                    Elija una opción:
                    4. Listar mascotas
                    5. Volver al menú principal
                    """);
            optionSelectedByUser = sc.nextInt();
            switch (optionSelectedByUser) {
                case 4 -> {
                    pe.getAllPets().forEach(System.out::println);
                    showMenuOptions();
                }
                case 5 -> showMenu();
            }
        }
    }

    // Operaciones con historias clínicas
    public void clinicalHistory() {
        System.out.println("""
                --- MENÚ HISTORIA CLÍNICA ---
                (Si usted no cuenta con permisos de administrador o veterinario, sólo podrá listar las historias clínicas)
                1. Agregar historia clínica
                2. Modificar historia clínica
                3. Listar historias clínicas
                4. Volver al menú principal
                """);
        try {
            optionSelectedByUser = sc.nextInt();
            if (optionSelectedByUser < 1 || optionSelectedByUser > 4) {
                throw new Exception("Error: Debe ingresar un número entre 1 y 4");
            } else {
                showClinicalHistoryOptions();
            }
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un número entero");
        }
    }

    private void showClinicalHistoryOptions() {
        if (currentPerson.getRole().toUpperCase().equals(Role.ADMIN.toString()) || currentPerson.getRole().toUpperCase().equals(Role.VET.toString())) {
            switch (optionSelectedByUser) {
                case 1 -> {
                    // Sacar el id de la historia clínica de la fecha actual en milisegundos
                    long id = System.currentTimeMillis();
                    System.out.print("ID del veterinario: ");
                    long vetId = sc.nextLong();
                    System.out.print("Raón de la consulta: ");
                    String reason = sc.next();
                    System.out.print("Síntomas: ");
                    String symptoms = sc.next();
                    System.out.print("Diagnóstico: ");
                    String diagnosis = sc.next();
                    System.out.print("Procedimiento: ");
                    String procedure = sc.next();
                    System.out.print("Medicamento: ");
                    String medication = sc.next();
                    System.out.print("Dosis: ");
                    String dose = sc.next();
                    System.out.print("ID de la orden: ");
                    String idOrder = sc.next();
                    System.out.print("Alergias: ");
                    String allergy = sc.next();
                    System.out.print("Detalle del procedimiento: ");
                    String procedureDetail = sc.next();
                    System.out.print("¿Se canceló la orden? (true/false): ");
                    boolean orderCancellation = sc.nextBoolean();

                    try {
                        clHistoryController.saveClHistory(new ClinicalHistory(id, vetId, reason, symptoms, diagnosis, procedure, medication, dose, idOrder, allergy, procedureDetail, orderCancellation));
                        System.out.println("Historia clínica creada con éxito");
                        clinicalHistory();
                    } catch (Exception e) {
                        System.out.println("Error al crear historia clínica: " + e);
                    }
                }
                case 2 -> {
                    System.out.print("ID de la historia clínica a modificar: ");
                    long id = sc.nextLong();
                    System.out.println("Modificando la historia clínica: " + clHistoryController.findClinicalHistoryByID((int) id));
                    System.out.print("ID del veterinario: ");
                    long vetId = sc.nextLong();
                    System.out.print("Raón de la consulta: ");
                    String reason = sc.next();
                    System.out.print("Síntomas: ");
                    String symptoms = sc.next();
                    System.out.print("Diagnóstico: ");
                    String diagnosis = sc.next();
                    System.out.print("Procedimiento: ");
                    String procedure = sc.next();
                    System.out.print("Medicamento: ");
                    String medication = sc.next();
                    System.out.print("Dosis: ");
                    String dose = sc.next();
                    System.out.print("ID de la orden: ");
                    String idOrder = sc.next();
                    System.out.print("Alergias: ");
                    String allergy = sc.next();
                    System.out.print("Detalle del procedimiento: ");
                    String procedureDetail = sc.next();
                    System.out.print("¿Se canceló la orden? (true/false): ");
                    boolean orderCancellation = sc.nextBoolean();

                    try {
                        clHistoryController.saveClHistory(new ClinicalHistory(id, vetId, reason, symptoms, diagnosis, procedure, medication, dose, idOrder, allergy, procedureDetail, orderCancellation));
                        System.out.println("Historia clínica con ID " + id + " modificada con éxito" + "Historia clínica= " + clHistoryController.findClinicalHistoryByID((int) id));
                        clinicalHistory();
                    } catch (Exception e) {
                        System.out.println("Error al modificar historia clínica: " + e);
                    }
                }
                case 3 -> {
                    clHistoryController.getAllClinicalHistory().forEach(System.out::println);
                    clinicalHistory();
                }
                case 4 -> showMenu();
            }
        }
    }
}
