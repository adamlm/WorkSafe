package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class changeEmail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        final Button updateEmail = findViewById(R.id.updateEmailButton);
        updateEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Implement code to update email for user
                String currEmail = ((EditText) findViewById(R.id.newEmailField)).toString();
                String confCurrEmail = ((EditText) findViewById(R.id.confirmNewEmailField)).toString();

                //if(currEmail.equals(confCurrEmail) && !currEmail.equals(null)) {
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

                    //dbReff.setValue(currEmail);
                    //database.child("users").child();
                    //database.child().
                //}
            }
        });
    }

}
