package com.example.seg2105hams;

public class Patient {
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String PhoneNo;
    private String Address;
    private String HealthCardNo;

    //Constructor
    public Patient(String firstName, String lastName, String email, String password, String phoneNo, String address, String healthCardNo) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        PhoneNo = phoneNo;
        Address = address;
        HealthCardNo = healthCardNo;
    }
    //Setter
    public void setFirstName(String firstName) {FirstName = firstName;}
    public void setLastName(String lastName) {LastName = lastName;}
    public void setEmail(String email) {Email = email;}
    public void setPassword(String password) {Password = password;}
    public void setPhoneNo(String phoneNo) {PhoneNo = phoneNo;}
    public void setAddress(String address) {Address = address;}
    public void setHealthCardNo(String healthCardNo) {HealthCardNo = healthCardNo;}

    //Getter
    public String getFirstName() {return FirstName;}
    public String getLastName() {return LastName;}
    public String getEmail() {return Email;}
    public String getPassword() {return Password;}
    public String getPhoneNo() {return PhoneNo;}
    public String getAddress() {return Address;}
    public String getHealthCardNo() {return HealthCardNo;}
}
