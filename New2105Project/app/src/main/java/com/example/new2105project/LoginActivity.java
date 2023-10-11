package com.example.new2105project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * 选择账户类型并点击跳转
     * */
    public void Patient_Register(View view){
        Intent intent = new Intent(getApplicationContext(), Patient_Register.class);
        startActivity(intent);
    }

    public void Doctor_Register(View view){
        Intent intent = new Intent(getApplicationContext(), Doctor_Register.class);
        startActivity(intent);
    }
}