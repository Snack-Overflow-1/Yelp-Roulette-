package com.snackoverflow.yelproulette;

 //Kelly, Janet, and Ivan through Liveshare

public class MongoDBUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // -----------Constructor----------
    public MongoDBUser(String newName, String newLastName, String newEmail, String newPassword) {
        this.firstName = newName;
        this.lastName = newLastName;
        this.email = newEmail;
        this.password = newPassword;
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

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }
    // ----------END DEFAULT METHODS----------
}
