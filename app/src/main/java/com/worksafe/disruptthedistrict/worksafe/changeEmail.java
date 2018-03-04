package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class changeEmail extends AppCompatActivity {
    Button updateEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);
        updateEmail = (Button)findViewById(R.id.updateEmailButton);
        updateEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Implement code to update email for user
            }
        });
    }

}
