package com.veterinaria.model;

public class Person {
    private long id;
    private String name;
    private int age;
    private String role;
    private String username;
    private String password;

    public Person() {
    }

    public Person(String name, int age, String role, String username, String password) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public Person(long id, String name, int age, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public Person(long id, String name, int age, String role, String username, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "ID: " + id + " Name: " + name + " Age: " + age + " Role: " + role + " Username: " + username + " Password: " + password;
    }
}
