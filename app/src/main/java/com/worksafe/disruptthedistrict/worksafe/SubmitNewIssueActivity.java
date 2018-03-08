package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SubmitNewIssueActivity extends AppCompatActivity {
    Button submitComplaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_new_issue);

        // Create toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Create New Issue");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite),
                PorterDuff.Mode.SRC_ATOP);

        // Submit button
        Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                boolean sexualAssault = ((CheckBox) findViewById(R.id.sexualAssaultBox)).isChecked();
                boolean racialComments = ((CheckBox) findViewById(R.id.RacialCommentsBox)).isChecked();
                boolean verbalAbuse = ((CheckBox) findViewById(R.id.VerbalAbuseBox)).isChecked();
                boolean physicalAbuse = ((CheckBox) findViewById(R.id.PhysicalAbuseBox)).isChecked();
                String details = ((EditText) findViewById(R.id.complaintComments)).getText().toString();

                Complaint complaint = new Complaint(sexualAssault, racialComments, verbalAbuse, physicalAbuse, details);
                LoginActivity.appUser.addComplaint(complaint);

                Intent returnToMain = new Intent(SubmitNewIssueActivity.this, MainScreenActivity.class);
                startActivity(returnToMain);
            }
        });
    }

    @Override
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
