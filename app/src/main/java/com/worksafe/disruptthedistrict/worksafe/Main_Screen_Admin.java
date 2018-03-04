package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class Main_Screen_Admin extends AppCompatActivity {
    ListView list;
    Button options;
    private List<String> List_file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen__admin);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Issue Feed - Admin");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));

        List_file = new ArrayList<String>();
        list = (ListView)findViewById(R.id.existingIssuesList_admin);
        CreateListView();

        options = (Button)findViewById(R.id.options_menu_admin);

        options.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Main_Screen_Admin.this, options);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.settings_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().toString().equals("Change Email")){
                            Intent goChangeEmail = new Intent(Main_Screen_Admin.this, changeEmail.class);
                            startActivity(goChangeEmail);
                        }
                        else if(item.getTitle().toString().equals("Change Password")){
                            Intent goChangePassword = new Intent(Main_Screen_Admin.this, changePassword.class);
                            startActivity(goChangePassword);
                        }
                        else if(item.getTitle().toString().equals("About")){
                            Intent goAbout = new Intent(Main_Screen_Admin.this, about.class);
                            startActivity(goAbout);
                        }
                        //Toast.makeText(Main_Screen.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });
    }
    private void CreateListView()
    {
        //Here is where we will connect to the data to retrieve old submitted issues
        for(int i = 0; i < Login.allComplaints.size(); i++){
            List_file.add(Login.allComplaints.get(i).getComplaintDetails() + "          " + Login.temp.getComplaint(i).getStatus());
        }
        /*
        List_file.add("Coderzheaven           " + "In Progress" );
        List_file.add("Google");
        List_file.add("Android");
        List_file.add("iPhone");
        List_file.add("iPhone");
        List_file.add("iPhone");
        List_file.add("iPhone");
        List_file.add("iPhone");
        List_file.add("iPhone");
        List_file.add("iPhone");
        List_file.add("iPhone");
        List_file.add("iPhone");
        List_file.add("iPhone");
        List_file.add("iPhone");
        */


        //Create an adapter for the listView and add the ArrayList to the adapter.
        list.setAdapter(new ArrayAdapter<String>(Main_Screen_Admin.this, android.R.layout.simple_list_item_1,List_file));
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
