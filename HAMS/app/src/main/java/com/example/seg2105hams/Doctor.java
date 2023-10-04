package com.example.seg2105hams;

import java.util.ArrayList;
import java.util.Collections;

public class Doctor {
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String PhoneNo;
    private String Address;
    private String EmployeeNo;
    private ArrayList<String> Specialties;

    //Constructor
    public Doctor(String firstName,String lastName,String email,String password,String phoneNo,String address,String employeeNo,ArrayList<String> specialties){
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        PhoneNo = phoneNo;
        Address = address;
        EmployeeNo = employeeNo;
        Collections.sort(specialties);
        Specialties = specialties;
    }
    //Setters
    public void setFirstName(String firstName) {FirstName = firstName;}
    public void setLastName(String lastName) {LastName = lastName;}
    public void setEmail(String email) {Email = email;}
    public void setPassword(String password) {Password = password;}
    public void setPhoneNo(String phoneNo) {PhoneNo = phoneNo;}
    public void setAddress(String address) {Address = address;}
    public void setEmployeeNo(String employeeNo) {EmployeeNo = employeeNo;}
    public void setSpecialties(ArrayList<String> specialties) {
        Collections.sort(specialties);
        Specialties = specialties;
    }

    //Getters
    public String getFirstName() {return FirstName;}
    public String getLastName() {return LastName;}
    public String getEmail() {return Email;}
    public String getPassword() {return Password;}
    public String getPhoneNo() {return PhoneNo;}
    public String getAddress() {return Address;}
    public String getEmployeeNo() {return EmployeeNo;}
    public ArrayList<String> getSpecialties() {return Specialties;}

}