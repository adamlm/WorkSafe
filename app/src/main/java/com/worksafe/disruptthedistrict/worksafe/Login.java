package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.*;
import android.view.*;
import android.view.inputmethod.EditorInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnKeyListener{
    static User appUser;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseAuth.getInstance().signOut();

        loginString = (EditText) findViewById(R.id.Email_field);
        passwordString = (EditText) findViewById(R.id.Password_Field);
        //login = (Button)findViewById(R.id.Login_button);

        TextView register = (TextView) findViewById(R.id.registerAccountText);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoRegister = new Intent(Login.this, CreateNewAccount.class);
                Login.this.startActivity(gotoRegister);
            }
        });

        EditText passwordText = (EditText) findViewById(R.id.Password_Field);
        passwordText.setOnKeyListener(this);
        mAuth = FirebaseAuth.getInstance();

        logInAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(Login.this, Main_Screen.class));
                }
            }
        };

    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        EditText passwordText = (EditText) findViewById(R.id.Password_Field);

        if (keyCode == EditorInfo.IME_ACTION_SEARCH ||
                keyCode == EditorInfo.IME_ACTION_DONE ||
                event.getAction() == KeyEvent.ACTION_DOWN &&
                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

            if (!event.isShiftPressed()) {
                startSignIn();
            }

            return true;
        }

        return false;
    }

    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(logInAuthListner);
    }

    private void startSignIn() {
        final String loginString2 = loginString.getText().toString();;
        //User user = new User(0,"","", true);
        //user.setUsername = loginString.getText().toString();
        String passwordString2 = passwordString.getText().toString();;

        if (TextUtils.isEmpty(loginString2) || TextUtils.isEmpty(passwordString2)) {
            Toast.makeText(Login.this, "Fields are empty", Toast.LENGTH_LONG).show();
        } else {
            mAuth.signInWithEmailAndPassword(loginString2, passwordString2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(Login.this, "Sign in Problem", Toast.LENGTH_LONG).show();
                    } else {
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("user");

                        //Login.appUser = databaseReference.child(loginString);
                        Intent gotoMain = new Intent(Login.this, Main_Screen.class);
                        Login.this.startActivity(gotoMain);
                    }
                }
            });


        }
    }



}
