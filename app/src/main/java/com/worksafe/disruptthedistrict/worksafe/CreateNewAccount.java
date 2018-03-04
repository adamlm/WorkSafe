package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateNewAccount extends AppCompatActivity {
    Button createNewAccount;
    private FirebaseAuth auth;
    private EditText etEmailAddress;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);
        auth = FirebaseAuth.getInstance();
        etEmailAddress = (EditText) findViewById(R.id.newAcc_Email);
        etPassword = (EditText) findViewById(R.id.newAcc_Password);
        createNewAccount = (Button)findViewById(R.id.newAccountButton);
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button


                String name = ((EditText)findViewById(R.id.newAcc_Name)).toString();
                String email = ((EditText)findViewById(R.id.newAcc_Email)).toString();
                String password = ((EditText)findViewById(R.id.newAcc_Password)).toString();;
                boolean isAdmin = ((CheckBox)findViewById(R.id.isAdminCheckBox)).isChecked();
                String company = ((EditText)findViewById(R.id.CompanyNameBox)).toString();

                if(isAdmin){
                    Admin newAdmin = new Admin(name, email, password, company);
                    Login.adminAccounts.add(newAdmin);
                    Login.companies.add(company);
                }
                else{
                    Employee newEmployee = new Employee(name, email, password, company);
                    Login.employeeAccounts.add(newEmployee);
                    Login.companies.add(company);
                }

                Intent goMainScreen = new Intent(CreateNewAccount.this, Main_Screen.class);
                startActivity(goMainScreen);
            }
        });

    }

   /* private void registerUser() {
        String email = etEmailAddress.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(RegisterActivity.this, "Please enter both the email and the password.", Toast.LENGTH_LONG).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //User registration successful
                    //move to homepage
                    Toast.makeText(RegisterActivity.this, "Registering...", Toast.LENGTH_LONG).show();
                    Intent registeredIntent = new Intent(RegisterActivity.this, SetupActivity.class);
                    RegisterActivity.this.startActivity(registeredIntent);
                } else {
                    Toast.makeText(RegisterActivity.this, "Could not register, please try again.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }*/
}
