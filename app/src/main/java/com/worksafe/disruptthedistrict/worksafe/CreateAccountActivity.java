package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
    Button createNewAccount;
    private EditText email;
    private EditText name;
    private EditText password;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Create Toolbar for Activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOverflowIcon(
                getResources().getDrawable(R.drawable.ic_more_vert_white_24dp));

        // Enable the back button in the Toolbar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        }


        auth = FirebaseAuth.getInstance();




        name = ((EditText)findViewById(R.id.field_first_name));
        email = ((EditText)findViewById(R.id.field_email));
        password = ((EditText)findViewById(R.id.newAcc_Password));
        createNewAccount = (Button)findViewById(R.id.register_butt);
        createNewAccount.setOnClickListener(this);



    }

    private void registerUser() {
        String stringemail = email.getText().toString().trim();
        String stringpassword = password.getText().toString().trim();

        if (TextUtils.isEmpty(stringemail) || TextUtils.isEmpty(stringpassword)) {
            Toast.makeText(CreateAccountActivity.this, "Please enter both the email and the password.", Toast.LENGTH_LONG).show();
            return;
        }

        auth.createUserWithEmailAndPassword(stringemail,stringpassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //User registration successful
                    //move to homepage
                    LoginActivity.appUser = new User(System.currentTimeMillis(), name.toString(), name.toString(), email.toString(),
                            password.toString(), false, null);

                    DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
                    database.child(Long.toString(LoginActivity.appUser.getUserId())).setValue(LoginActivity.appUser);

                    Toast.makeText(CreateAccountActivity.this, "Registering...", Toast.LENGTH_LONG).show();
                    Intent registeredIntent = new Intent(CreateAccountActivity.this, MainScreenActivity.class);
                    CreateAccountActivity.this.startActivity(registeredIntent);
                } else {
                    Toast.makeText(CreateAccountActivity.this, "Could not register, please try again.", Toast.LENGTH_LONG).show();
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
            Intent loginIntent = new Intent(CreateAccountActivity.this, LoginActivity.class);
            // Request for RegisterActivity to open the activity via the above intent.
            CreateAccountActivity.this.startActivity(loginIntent);
        }


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
