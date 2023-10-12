package com.example.new2105project.Entity;

import java.io.Serializable;

public class Account implements Serializable {
    private String name;
    private String password;

    private Account_Types account_types;

    private Gender gender;

    private String Role;

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Account() {
    }

    public Account(String name, String password, Account_Types account_types, Gender gender) {
        this.name = name;
        this.password = password;
        this.account_types = account_types;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account_Types getAccount_types() {
        return account_types;
    }

    public void setAccount_types(Account_Types account_types) {
        this.account_types = account_types;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", account_types=" + account_types +
                ", gender=" + gender +
                '}';
    }
}