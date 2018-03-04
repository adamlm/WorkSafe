package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    Button login;
    boolean isAdmin = false;
    public static Employee temp = new Employee("KY","ky@google.com", "ky123","kyinc");

    //, createNewAccount;
    public static ArrayList<String> companies;
    public static ArrayList<Admin> adminAccounts;
    public static ArrayList<Employee> employeeAccounts;
    public static ArrayList<Complaint> allComplaints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button)findViewById(R.id.Login_button);
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



}
