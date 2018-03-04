package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import android.view.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import java.util.ArrayList;

public class Login extends AppCompatActivity {
    Button login;
    boolean isAdmin = false;
    public static Employee temp = new Employee("KY","ky@google.com", "ky123","kyinc");

    //, createNewAccount;
    //private EditText loginET;
    //private EditText passwordET;
    private EditText loginString;
    private EditText passwordString;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener logInAuthListner;
    public static ArrayList<String> companies;
    public static ArrayList<Admin> adminAccounts;
    public static ArrayList<Employee> employeeAccounts;
    public static ArrayList<Complaint> allComplaints;

    public Login() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginString= (EditText) findViewById(R.id.Email_field);
        passwordString = (EditText) findViewById(R.id.Password_Field);
        login = (Button)findViewById(R.id.Login_button);

        /*
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent goToMain = new Intent(Login.this, Main_Screen_Admin.class);
                Intent goToMain2 = new Intent(Login.this, Main_Screen.class);
                if(isAdmin){
                    startActivity(goToMain);
                    String compID = "" + 1;
                    String status = "New";
                    String compDetails = "Testing Complaint";
                    allComplaints = new ArrayList<Complaint>();

                    //Toast.makeText(getApplicationContext(), compDetails,
                    //      Toast.LENGTH_LONG).show();
                    Complaint complaint = new Complaint(compID, status, compDetails);
                    allComplaints.add(complaint);
                    Login.temp.addComplaint(complaint);
                    Login.temp.setNumComplaints(Login.temp.getNumComplaints()+1);
                }
                else{
                    startActivity(goToMain2);
                }
                */
        mAuth = FirebaseAuth.getInstance();

        logInAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(Login.this, Main_Screen.class));
                }
            }
        };
        login.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startSignIn();
                    //Intent goToMain = new Intent(Login.this, Main_Screen_Admin.class);
                    //Intent goToMain2 = new Intent(Login.this, Main_Screen.class)

                        //startActivity(goToMain2);

                }
        });
        /*
        createNewAccount = (Button)findViewById(R.id.createNewAccountButton);
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent goToMain = new Intent(Login.this, CreateNewAccount.class);
                startActivity(goToMain);
            }
        });
        */
    }
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(logInAuthListner);
    }

    private void startSignIn() {
        String loginString2 = loginString.getText().toString();;
        //User user = new User(0,"","", true);
        //user.setUsername = loginString.getText().toString();
        String passwordString2 = passwordString.getText().toString();;


        if (TextUtils.isEmpty(loginString2) || TextUtils.isEmpty(passwordString2)) {
            Toast.makeText(Login.this, "Fields are empty", Toast.LENGTH_LONG).show();
        }
        else{
            mAuth.signInWithEmailAndPassword(loginString2, passwordString2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(Login.this, "Sign in Problem", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }



}
