package com.example.new2105project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.new2105project.Entity.Account;

public class Welcome extends AppCompatActivity {

    Account account;

    TextView welcomeTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeTextview= (TextView) findViewById(R.id.welcomeTextView);

        Intent intent = getIntent();
        account = (Account) intent.getSerializableExtra("account");
        welcomeTextview.setText(String.format("Welcome %s as a %s", account.getName(), account.getRole()));
    }
}