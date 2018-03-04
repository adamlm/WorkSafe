package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;



public class CreateNewAccount extends AppCompatActivity {
    Button createNewAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register Account");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite),
                PorterDuff.Mode.SRC_ATOP);

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
