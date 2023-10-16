package com.example.new2105project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.new2105project.Entity.Account;
import com.example.new2105project.Entity.Account_Types;
import com.example.new2105project.Entity.Gender;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Doctor_Register extends AppCompatActivity {


    /**
     * Create variables that will be used
     * */
    DatabaseReference accountRefference;

    EditText firstEditText, lastEditText, passwordEditText, emailEditText, phoneNumEditText, addressEditText, employeeNumEditText, specialtiesEditText;

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
        firstEditText= (EditText) findViewById(R.id.doctor_FirstNameEditText);
        lastEditText = (EditText) findViewById(R.id.doctor_LastNameEditText);
        passwordEditText = (EditText) findViewById(R.id.doctor_PasswordEditText);

        phoneNumEditText = (EditText) findViewById(R.id.doctor_PhoneNumberEditText);
        //if (phoneNumEditText.equals("")) {
          //  Toast toast = Toast.makeText(getApplicationContext(), "Phone number can't be empty!", Toast.LENGTH_LONG);
            //toast.show();
        //} else if (isPositiveInteger(phoneNumEditText.getText().toString())) {
          //  Toast toast = Toast.makeText(getApplicationContext(), "Phone number not valid!", Toast.LENGTH_LONG);
            //toast.show();
        //} else {}



        addressEditText = (EditText) findViewById(R.id.doctor_AddressEditText);
        employeeNumEditText = (EditText) findViewById(R.id.doctor_EmployeeNumberEditText);
        specialtiesEditText = (EditText) findViewById(R.id.doctor_SpecialtiesEditText);
        emailEditText = (EditText) findViewById(R.id.doctor_EmailEditText);
        genderGroup = (RadioGroup) findViewById(R.id.doctor_genderGroup);

    }

   // private static final String POSITIVE_INTEGER_REGEX = "[0-9]+";
    //private static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile(POSITIVE_INTEGER_REGEX);

    //public static final boolean isPositiveInteger(String s) {
      //  return POSITIVE_INTEGER_PATTERN.matcher(s).matches();
    //}

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

        /**
         * Put data into database
         * */
    public void register(View view) {
        String first = firstEditText.getText().toString();
        String last = lastEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String phoneNum = phoneNumEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String employeeNum = employeeNumEditText.getText().toString();
        String specialties = specialtiesEditText.getText().toString();
        String email = emailEditText.getText().toString();
        /**
         * Select gender
         * */
        Gender gender = null;
        if (genderGroup.getCheckedRadioButtonId() == R.id.doctor_MaleButton){
            gender = Gender.MALE;
        } else if (genderGroup.getCheckedRadioButtonId() == R.id.doctor_FemaleButton){
            gender = Gender.FEMALE;
        }

        String target = specialties;
        String[] role = {"family medicine", "internal medicine", "pediatrics", "obstetrics", "gynecology"};

        boolean allRolesExist = checkAllRolesExist(target, role);



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
        if (phoneNum.equals("") || !isNumber(phoneNum)) {
            Toast toast = Toast.makeText(getApplicationContext(), "Phone number can't be empty and it must be a number!", Toast.LENGTH_LONG);
            toast.show();
        } else if (first.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "First name can't be empty!", Toast.LENGTH_LONG);
            toast.show();
        } else if (last.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "last name can't be empty!", Toast.LENGTH_LONG);
            toast.show();
        }else if (password.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Password can't be empty!", Toast.LENGTH_LONG);
            toast.show();
        }else if (address.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Address can't be empty!", Toast.LENGTH_LONG);
            toast.show();
        }else if (employeeNum.equals("") || !isNumber(employeeNum)) {
            Toast toast = Toast.makeText(getApplicationContext(), "Employee number can't be empty and it must be a number!", Toast.LENGTH_LONG);
            toast.show();
        }else if (specialties.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Specialties can't be empty!", Toast.LENGTH_LONG);
            toast.show();
        } else if (!allRolesExist) {
            Toast toast = Toast.makeText(getApplicationContext(), "Specialties not correct!", Toast.LENGTH_LONG);
            toast.show();
        } else if (email.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Email can't be empty!", Toast.LENGTH_LONG);
            toast.show();
        }/*else if(!isValidEmail(email)){
            Toast toast = Toast.makeText(getApplicationContext(), "Email invalid!", Toast.LENGTH_LONG);
            toast.show();
        }*/else {
            Account account = new Account(first, last, password, Account_Types.DOCTOR, gender, phoneNum, address, employeeNum, specialties, email);
            accountRefference.child(email).setValue(account);
            finish();
        }



    }

    // Function to check if all roles in the target string belong to the role array
    public static boolean checkAllRolesExist(String target, String[] roleArray) {
        String[] targetRoles = target.split(", ");

        for (String targetRole : targetRoles) {
            if (!containsRole(roleArray, targetRole)) {
                return false;
            }
        }
        return true;
    }

    // Function to check if a role is in the role array
    public static boolean containsRole(String[] roleArray, String targetRole) {
        for (String role : roleArray) {
            if (role.equals(targetRole)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Testing is a String if it can be convert to integer
     *
     * @param s
     * @return: boolean
     */
    public boolean isNumber(String s){
        try{
            int number = Integer.valueOf(s);
        } catch (Exception e){
            return false;
        }
        return true;
    }

}