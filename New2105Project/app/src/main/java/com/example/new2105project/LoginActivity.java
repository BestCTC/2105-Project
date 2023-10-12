package com.example.new2105project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.new2105project.Entity.Account;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    DatabaseReference accountsReference;

    EditText accountEditText, passwordEditText;

    String name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        connectDB();
        initComponent();
    }

    private void connectDB() {
        accountsReference = FirebaseDatabase.getInstance().getReference("accounts");
    }

    private void initComponent() {
        accountEditText = (EditText) findViewById(R.id.patient_firstNameEditText);
        passwordEditText = (EditText) findViewById(R.id.patient_passwordEditText);
    }

    /**
     * 选择账户类型并点击跳转到选择角色的页面
     */
    public void Patient_Register(View view) {
        Intent intent = new Intent(getApplicationContext(), SelectRole.class);
        startActivity(intent);
    }

    public void Doctor_Register(View view) {
        Intent intent = new Intent(getApplicationContext(), SelectRole.class);
        startActivity(intent);
    }

    public void login(View view) {
        name = accountEditText.getText().toString();
        password = passwordEditText.getText().toString();

        /**
         * 若登陆时未填写姓名或密码,发出提示
         * */
        if (name.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Account name can't be empty!", Toast.LENGTH_SHORT);
            toast.show();
        } else if (password.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Password can't be empty!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            accountsReference.child(name).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    Account account = task.getResult().getValue(Account.class);
                    if (account == null) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Account dosen't exist!", Toast.LENGTH_SHORT);
                        toast.show();
                    } else if (!password.equals(account.getPassword())) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Password is incorrect!", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Intent intent = new Intent(getApplicationContext(), Welcome.class);
                        intent.putExtra("account", account);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}