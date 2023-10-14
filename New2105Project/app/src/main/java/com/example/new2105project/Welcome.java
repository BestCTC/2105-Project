package com.example.new2105project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.new2105project.Entity.Account;

public class Welcome extends AppCompatActivity {

    Account account;

    TextView welcomeTextview;

    /**
     * 所有的R.id.
     * 必须和 对应layout 上的
     * 按键/文本框/button的ID保持一致
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeTextview= (TextView) findViewById(R.id.welcomeTextView);

        Intent intent = getIntent();
        account = (Account) intent.getSerializableExtra("account");
        welcomeTextview.setText(String.format("Welcome! You (%s) are logged in as <%s>! ", account.getName(), account.getAccount_types()));
    }

    public void logoff(View view) {
        finish();
    }
}