package com.example.new2105project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.new2105project.Entity.Account;
import com.example.new2105project.Entity.Account_Types;
import com.example.new2105project.Entity.Gender;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Doctor_Register extends AppCompatActivity {


    /**
     * Create variables that will be used
     * */
    DatabaseReference accountRefference;

    EditText accountEditText, passwordEditText, phoneNumEditText, addressEditText, employeeNumEditText, specialtiesEditText;

    RadioGroup genderGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);

        connectDB();
        initialComponent();
    }

    /**
     * Actively connect to the database
     * */
    private void connectDB(){
        accountRefference = FirebaseDatabase.getInstance().getReference("accounts");


        accountRefference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()){
                    System.out.println(child);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    /**
     * All R.id.
     * Must correspond to on the layout
     * Keep the IDs of keys/text boxes/buttons consistent
     *
     * Read the input information from the layout and put it into the variable created in the above lines
     * (EditText) findViewById(R.id.firstNameEditText)
     * (Text/button type in layout) findViewById (R.id. corresponds to the name of the text box/button)
     * */
    private void initialComponent() {
        accountEditText = (EditText) findViewById(R.id.doctor_FirstNameEditText);
        passwordEditText = (EditText) findViewById(R.id.doctor_PasswordEditText);
        phoneNumEditText = (EditText) findViewById(R.id.doctor_PhoneNumberEditText);
        addressEditText = (EditText) findViewById(R.id.doctor_AddressEditText);
        employeeNumEditText = (EditText) findViewById(R.id.doctor_EmployeeNumberEditText);
        specialtiesEditText = (EditText) findViewById(R.id.doctor_SpecialtiesEditText);
        genderGroup = (RadioGroup) findViewById(R.id.doctor_genderGroup);

    }


    /**
     * Put data into database
     * */
    public void register(View view) {
        String name = accountEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String phoneNum = phoneNumEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String employeeNum = employeeNumEditText.getText().toString();
        String specialties = specialtiesEditText.getText().toString();
        /**
         * Select gender
         * */
        Gender gender = null;
        if (genderGroup.getCheckedRadioButtonId() == R.id.doctor_MaleButton){
            gender = Gender.MALE;
        } else if (genderGroup.getCheckedRadioButtonId() == R.id.doctor_FemaleButton){
            gender = Gender.FEMALE;
        }




        //genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        //  @Override
        //public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //  if (i ==R.id.MaleButton){
        //    gender = Gender.MALE;
        //} else {
        //  gender = Gender.FEMALE;
        //}
        //}
        //});

        Account account = new Account(name, password, Account_Types.DOCTOR, gender, phoneNum, address, employeeNum, specialties);
        accountRefference.child(name).setValue(account);

        finish();
    }
}