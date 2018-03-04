package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Submit_New_Issue extends AppCompatActivity {
    Button submitComplaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit__new__issue);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create New Issue");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite),
                PorterDuff.Mode.SRC_ATOP);

        Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent returnToMain = new Intent(Submit_New_Issue.this, Main_Screen.class);
                String compID = "" + Login.temp.getNumComplaints();
                String status = "New";
                String compDetails = ((EditText)findViewById(R.id.complaintComments)).getText().toString();
                Toast.makeText(getApplicationContext(), compDetails,
                        Toast.LENGTH_LONG).show();
                Complaint complaint = new Complaint(compID, status, compDetails);
                Login.temp.addComplaint(complaint);
                Login.temp.setNumComplaints(Login.temp.getNumComplaints()+1);
                startActivity(returnToMain);
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
