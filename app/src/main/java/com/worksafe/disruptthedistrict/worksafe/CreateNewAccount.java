package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CreateNewAccount extends AppCompatActivity {
    Button createNewAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);
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
}
