package com.example.new2105project;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;

        import com.example.new2105project.Entity.Account;
        import com.example.new2105project.Entity.Account_Types;
        import com.example.new2105project.Entity.Gender;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

public class Patient_Register extends AppCompatActivity {


    DatabaseReference accountRefference;

    EditText accountEditText, passwordEditText;

    RadioGroup genderGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);

        connectDB();
        initialComponent();

    }


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

    private void initialComponent() {
        accountEditText = (EditText) findViewById(R.id.accounteditText);
        passwordEditText = (EditText) findViewById(R.id.passwordeditText);
        genderGroup = (RadioGroup) findViewById(R.id.genderGroup);
    }

    public void register(View view) {
        String name = accountEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        Gender gender = null;
        if (genderGroup.getCheckedRadioButtonId() == R.id.MaleButton){
            gender = Gender.MALE;
        } else if (genderGroup.getCheckedRadioButtonId() == R.id.FemaleButton){
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

        //Account account = new Account(name, password, Account_Types.PATIENT, );
        //accountRefference.child(name).setValue(account);
    }
}