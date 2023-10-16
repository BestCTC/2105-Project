package com.example.new2105project.Entity;

import java.io.Serializable;

public class Account implements Serializable {
    private String firstName;
    private String lastName;
    private String password;

    private Account_Types account_types;

    private Gender gender;

    private String phoneNum;
    private String address;
    private String email;
    private String empNumOrCardNum;
    private String specialties;

    private String Role;

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Account() {
    }

    public Account(String firstName,String lastName, String password, Account_Types account_types, Gender gender, String phoneNum, String address, String empNumOrCardNum, String specialties, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.account_types = account_types;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.address = address;
        this.empNumOrCardNum = empNumOrCardNum;
        this.specialties = specialties;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmpNumOrCardNum() {
        return empNumOrCardNum;
    }

    public void setEmpNumOrCardNum(String empNumOrCardNum) {
        this.empNumOrCardNum = empNumOrCardNum;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {

        if(account_types.equals(Account_Types.DOCTOR)){
            return "Account{" +
                    "first name='" + firstName + '\'' +
                    "last name='" + lastName + '\'' +
                    ", password='" + password + '\'' +
                    ", account_types=" + account_types +'\'' +
                    ", email='" + email + '\'' +
                    ", gender=" + gender +'\'' +
                    ", phone number=" + phoneNum +'\'' +
                    ", address=" + address +'\'' +
                    ", employee number=" + empNumOrCardNum +'\'' +
                    '}';
        }

        else if(account_types.equals(Account_Types.PATIENT)){
            return "Account{" +
                    "first name='" + firstName + '\'' +
                    "last name='" + lastName + '\'' +
                    ", password='" + password + '\'' +
                    ", account_types=" + account_types +'\'' +
                    ", email='" + email + '\'' +
                    ", gender=" + gender +'\'' +
                    ", phone number=" + phoneNum +'\'' +
                    ", address=" + address +'\'' +
                    ", health card number=" + empNumOrCardNum +'\'' +
                    '}';
        }
        else{
            return "Account{" +
                    "login name='" + email + '\'' +
                    ", password='" + password + '\'' +", account_types=" + account_types +"}";
        }

    }
}
