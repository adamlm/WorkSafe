package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.PopupMenu;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Main_Screen extends AppCompatActivity {
    ListView list;
    Button settings;
    Button newIssue;
    Toolbar toolbar;

    Button options;
    Button newIssueBtn;

    private List<String> List_file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Issue Feed");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));


        List_file = new ArrayList<String>();
        list = (ListView)findViewById(R.id.existingIssuesList);
        CreateListView();

        options = (Button)findViewById(R.id.options_menu);
        options.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Main_Screen.this, options);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.settings_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().toString().equals("Change Email")){
                            Intent goChangeEmail = new Intent(Main_Screen.this, changeEmail.class);
                            startActivity(goChangeEmail);
                        }
                        else if(item.getTitle().toString().equals("Change Password")){
                            Intent goChangePassword = new Intent(Main_Screen.this, changePassword.class);
                            startActivity(goChangePassword);
                        }
                        else if(item.getTitle().toString().equals("About")){
                            Intent goAbout = new Intent(Main_Screen.this, about.class);
                            startActivity(goAbout);
                        } else if(item.getTitle().toString().equals("Logout")){
                            FirebaseAuth.getInstance().signOut();
                            Intent gologin = new Intent(Main_Screen.this, Login.class);
                            startActivity(gologin);
                        }
                        //Toast.makeText(Main_Screen.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });

        newIssue = (Button)findViewById(R.id.new_issue_button);
        newIssue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent goToSettings = new Intent(Main_Screen.this, Submit_New_Issue.class);
                startActivity(goToSettings);
            }
        });

        this.CreateListView();
    }
    private void CreateListView()
    {
        //Here is where we will connect to the data to retrieve old submitted issues
        for(int i = 0; i < Login.temp.getNumComplaints(); i++){
            List_file.add(Login.temp.getComplaint(i).getComplaintDetails() + "          " + Login.temp.getComplaint(i).getStatus());
        }
        /*
        List_file.add("Coderzheaven           " + "In Progress" );
        List_file.add("Google");
        List_file.add("Android");
        List_file.add("iPhone");
        List_file.add("Apple");
        List_file.add("Apple");
        List_file.add("Apple");
        List_file.add("Apple");
        List_file.add("Apple");
        List_file.add("Apple");
        List_file.add("Apple");
        List_file.add("Apple");
        List_file.add("Apple");
        List_file.add("Apple");
        List_file.add("Apple");
        */

        //Create an adapter for the listView and add the ArrayList to the adapter.
        list.setAdapter(new ArrayAdapter<String>(Main_Screen.this, android.R.layout.simple_list_item_1,List_file));
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
        // Do nothing
    }
}
