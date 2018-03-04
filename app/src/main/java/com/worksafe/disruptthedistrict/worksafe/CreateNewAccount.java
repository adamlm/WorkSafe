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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


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

                String firstName = ((EditText)findViewById(R.id.newAcc_FirstName)).toString();
                String lastName = ((EditText)findViewById(R.id.newAcc_LastName)).toString();
                String email = ((EditText)findViewById(R.id.newAcc_Email)).toString();
                String password = ((EditText)findViewById(R.id.newAcc_Password)).toString();;

                if(firstName.equals(null) || lastName.equals(null) || email.equals(null)
                        || password.equals(null)) {
                    Toast.makeText(CreateNewAccount.this,
                            "Please fill out all fields.", Toast.LENGTH_LONG).show();
                } else {
                    //DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users");
                    //DataSnapshot snapshot = userRef.;
                    //snapshot.child("users").getChildrenCount() + 1;
                    //int userId = userRef.getch
                    //fbDb = FirebaseDatabase.getInstance().getReference();

                    User user = new User(5, firstName, lastName, email, password, false);

                    Intent goMainScreen = new Intent(CreateNewAccount.this, Main_Screen.class);
                    startActivity(goMainScreen);
                }
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
