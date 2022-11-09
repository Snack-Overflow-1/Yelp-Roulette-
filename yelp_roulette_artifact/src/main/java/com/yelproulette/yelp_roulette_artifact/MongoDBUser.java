package com.yelproulette.yelp_roulette_artifact;

public class MongoDBUser {
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    // -----------Constructor----------
    public MongoDBUser(String newName, String newLastName, String newEmail, int newAge) {
        this.firstName = newName;
        this.lastName = newLastName;
        this.email = newEmail;
        this.age = newAge;
    }

    // ----------DEFAULT METHODS----------
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // ----------END DEFAULT METHODS----------
}
