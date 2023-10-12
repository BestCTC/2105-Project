package com.example.new2105project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectRole extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_role);
    }

    public void registerPatient(View view){
        Intent intent = new Intent(getApplicationContext(), Patient_Register.class);
        startActivity(intent);
        finish();
    }

    public void registerDoctor(View view){
        Intent intent = new Intent(getApplicationContext(), Doctor_Register.class);
        startActivity(intent);
        finish();
    }
}