package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.PopupMenu;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainScreenActivity extends AppCompatActivity {
    ListView list;
    Button settings;
    Button newIssue;
    Toolbar toolbar;

    Button options;
    Button newIssueBtn;

    private ArrayList<String> List_file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        // Create Toolbar for Activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOverflowIcon(
                getResources().getDrawable(R.drawable.ic_more_vert_white_24dp));

//
//        List_file = new ArrayList<String>();
//        list = (ListView)findViewById(R.id.existingIssuesList);
//        CreateListView();
//
//        options = (Button)findViewById(R.id.options_menu);
//        options.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                //Creating the instance of PopupMenu
//                PopupMenu popup = new PopupMenu(MainScreenActivity.this, options);
//                //Inflating the Popup using xml file
//                popup.getMenuInflater().inflate(R.menu.menu_settings, popup.getMenu());
//
//                //registering popup with OnMenuItemClickListener
//                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    public boolean onMenuItemClick(MenuItem item) {
//                        if(item.getTitle().toString().equals("Change Email")){
//                            Intent goChangeEmail = new Intent(MainScreenActivity.this, ChangeEmailActivity.class);
//                            startActivity(goChangeEmail);
//                        }
//                        else if(item.getTitle().toString().equals("Change Password")){
//                            Intent goChangePassword = new Intent(MainScreenActivity.this, ChangePasswordActivity.class);
//                            startActivity(goChangePassword);
//                        }
//                        else if(item.getTitle().toString().equals("About")){
//                            Intent goAbout = new Intent(MainScreenActivity.this, AboutActivity.class);
//                            startActivity(goAbout);
//                        } else if(item.getTitle().toString().equals("Logout")){
//                            FirebaseAuth.getInstance().signOut();
//                            Intent gologin = new Intent(MainScreenActivity.this, LoginActivity.class);
//                            startActivity(gologin);
//                        }
//                        //Toast.makeText(MainScreenActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
//                        return true;
//                    }
//                });
//
//                popup.show();//showing popup menu
//            }
//        });
//
//        newIssue = (Button)findViewById(R.id.new_issue_button);
//        newIssue.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//                Intent goToSettings = new Intent(MainScreenActivity.this, SubmitNewIssueActivity.class);
//                startActivity(goToSettings);
//            }
//        });
//
//        //this.CreateListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_change_email:
                return true;

            case R.id.action_change_password:
                return true;

            case R.id.action_about:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void CreateListView()
    {
            //Here is where we will connect to the data to retrieve old submitted issues
            for (int i = 0; i < LoginActivity.appUser.getComplaints().size(); i++) {

                //List_file.add(LoginActivity.appUser.getComplaints().get(i).toString());
                List_file.add("TEST");
            }
            //Create an adapter for the listView and add the ArrayList to the adapter.
            //existingIssuesList


        list.setAdapter(new ArrayAdapter<String>(MainScreenActivity.this, android.R.layout.simple_list_item_1, List_file));

        /*
        List_file.add("Coderzheaven           " + "In Progress" );
        List_file.add("Google");



        /*
        list.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
            {
                //args2 is the listViews Selected index
            }
        });
        */
    }

    @Override
    public void onBackPressed() {
        // Do nothing - Needed to prevent users from returning to Login Activity
    }
}
