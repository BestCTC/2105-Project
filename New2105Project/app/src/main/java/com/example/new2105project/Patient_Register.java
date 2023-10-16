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

public class Patient_Register extends AppCompatActivity {


    /**
     * Create variables that will be used
     * */
    DatabaseReference accountRefference;

    EditText firstEditText, lastEditText, passwordEditText, emailEditText, phoneNumEditText, addressEditText, healthCardNumEditText;

    RadioGroup genderGroup;

    /**
     * The few lines of code that originally came with it,
     * connectDB(): actively connect to the database
     * initialComponent(): read the input information from the layout and put it into the variable created in the above lines.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);

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
        firstEditText = (EditText) findViewById(R.id.patient_firstNameEditText);
        lastEditText = (EditText) findViewById(R.id.patient_lastNameEditText);
        passwordEditText = (EditText) findViewById(R.id.patient_passwordEditText);
        genderGroup = (RadioGroup) findViewById(R.id.patient_genderGroup);
        phoneNumEditText = (EditText) findViewById(R.id.patient_phoneNumberEditText);
        addressEditText = (EditText) findViewById(R.id.patient_addressEditText);
        healthCardNumEditText = (EditText) findViewById(R.id.patient_healthCardNumberEditText);
        emailEditText = (EditText) findViewById(R.id.patient_emailEditText);
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
        String healthCardNum = healthCardNumEditText.getText().toString();
        String email = emailEditText.getText().toString();
        /**
         * Select gender
         * */
        Gender gender = null;
        if (genderGroup.getCheckedRadioButtonId() == R.id.patient_MaleButton){
            gender = Gender.MALE;
        } else if (genderGroup.getCheckedRadioButtonId() == R.id.patient_FemaleButton){
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


        if (phoneNum.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Phone number can't be empty!", Toast.LENGTH_LONG);
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
        }else if (healthCardNum.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Health card number can't be empty!", Toast.LENGTH_LONG);
            toast.show();
        }else if (email.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Email can't be empty!", Toast.LENGTH_LONG);
            toast.show();
        }else {
            Account account = new Account(first, last, password, Account_Types.PATIENT, gender, phoneNum, address, healthCardNum, null,email);
            accountRefference.child(email).setValue(account);

            /**
             * Exit current page
             * */
            finish();
        }


    }
}