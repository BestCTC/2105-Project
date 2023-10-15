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
     * 创建会用到的variable
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
     * 主动连接到database
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
     * 所有的R.id.
     * 必须和 对应layout 上的
     * 按键/文本框/button的ID保持一致
     *
     * 从layout中读取输入的信息，放到上面几行创建的variable里
     * (EditText) findViewById(R.id.firstNameEditText）
     * (layout中的文本/按钮类型) findViewById（R.id.对应文本框/按钮的名字）
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
     * 将数据放到database
     * */
    public void register(View view) {
        String name = accountEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String phoneNum = phoneNumEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String employeeNum = employeeNumEditText.getText().toString();
        /**
         * 选择性别
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

        Account account = new Account(name, password, Account_Types.DOCTOR, gender, phoneNum, address, employeeNum);
        accountRefference.child(name).setValue(account);

        finish();
    }
}