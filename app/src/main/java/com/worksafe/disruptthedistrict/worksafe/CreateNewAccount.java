package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
=======
>>>>>>> 619ce9f1efd9931d6f8404e12128e95e72ba5ec0
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
<<<<<<< HEAD

import com.google.firebase.auth.FirebaseAuth;

public class CreateNewAccount extends AppCompatActivity {
    Button createNewAccount;
    private FirebaseAuth auth;

=======
>>>>>>> 619ce9f1efd9931d6f8404e12128e95e72ba5ec0
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);
<<<<<<< HEAD
        auth = FirebaseAuth.getInstance();
=======
>>>>>>> 619ce9f1efd9931d6f8404e12128e95e72ba5ec0
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
<<<<<<< HEAD
=======
>>>>>>> 619ce9f1efd9931d6f8404e12128e95e72ba5ec0
}
