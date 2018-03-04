package com.worksafe.disruptthedistrict.worksafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class changePassword extends AppCompatActivity {
    Button updatePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        updatePassword = (Button)findViewById(R.id.updatePasswordButton);
        updatePassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Implement code to update password for user
            }
        });
    }
}
