package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {
    Button changeEmail, changePassword, about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        changeEmail = (Button)findViewById(R.id.changeEmailButton);
        changeEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent goChangeEmail = new Intent(SettingsActivity.this, ChangeEmailActivity.class);
                startActivity(goChangeEmail);
            }
        });

        changePassword = (Button)findViewById(R.id.changePasswordButton);
        changePassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent goChangePassword = new Intent(SettingsActivity.this, ChangePasswordActivity.class);
                startActivity(goChangePassword);
            }
        });

        about = (Button)findViewById(R.id.aboutButton);
        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent goAbout = new Intent(SettingsActivity.this, AboutActivity.class);
                startActivity(goAbout);
            }
        });
    }
}
