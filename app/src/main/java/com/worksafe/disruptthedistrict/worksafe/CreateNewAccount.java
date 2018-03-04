package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CreateNewAccount extends AppCompatActivity implements View.OnClickListener {
    Button createNewAccount;
    private EditText email;
    private EditText name;
    private EditText password;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register Account");
        auth = FirebaseAuth.getInstance();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite),
                PorterDuff.Mode.SRC_ATOP);

        name = ((EditText)findViewById(R.id.newAcc_Name));
        email = ((EditText)findViewById(R.id.newAcc_Email));
        password = ((EditText)findViewById(R.id.newAcc_Password));
        createNewAccount = (Button)findViewById(R.id.register_butt);
        createNewAccount.setOnClickListener(this);



    }

    private void registerUser() {
        String stringemail = email.getText().toString().trim();
        String stringpassword = password.getText().toString().trim();

        if (TextUtils.isEmpty(stringemail) || TextUtils.isEmpty(stringpassword)) {
            Toast.makeText(CreateNewAccount.this, "Please enter both the email and the password.", Toast.LENGTH_LONG).show();
            return;
        }

        auth.createUserWithEmailAndPassword(stringemail,stringpassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //User registration successful
                    //move to homepage
                    Login.appUser = new User(System.currentTimeMillis(), name.toString(), name.toString(), email.toString(),
                            password.toString(), false, null);

                    DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
                    database.child(Long.toString(Login.appUser.getUserId())).setValue(Login.appUser);

                    Toast.makeText(CreateNewAccount.this, "Registering...", Toast.LENGTH_LONG).show();
                    Intent registeredIntent = new Intent(CreateNewAccount.this, Main_Screen.class);
                    CreateNewAccount.this.startActivity(registeredIntent);
                } else {
                    Toast.makeText(CreateNewAccount.this, "Could not register, please try again.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onClick(View view) {
        if (view == createNewAccount) {
            registerUser();
        }
        else {
            // Intent to open the login activity.
            Intent loginIntent = new Intent(CreateNewAccount.this, Login.class);
            // Request for RegisterActivity to open the activity via the above intent.
            CreateNewAccount.this.startActivity(loginIntent);
        }


    }
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
