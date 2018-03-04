package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        submitComplaint = (Button)findViewById(R.id.submitComplaint);
        submitComplaint.setOnClickListener(new View.OnClickListener() {
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
}
