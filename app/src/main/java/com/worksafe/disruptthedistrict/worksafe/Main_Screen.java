package com.worksafe.disruptthedistrict.worksafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class Main_Screen extends AppCompatActivity {
    ListView list;
    Button settings;
    Button newIssue;
    private List<String> List_file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen);
        List_file = new ArrayList<String>();
        list = (ListView)findViewById(R.id.existingIssuesList);
        CreateListView();

        settings = (Button)findViewById(R.id.Settings_Button);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent goToSettings = new Intent(Main_Screen.this, Settings.class);
                startActivity(goToSettings);
            }
        });

        newIssue = (Button)findViewById(R.id.New_Issue_Button);
        newIssue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent goToSettings = new Intent(Main_Screen.this, Submit_New_Issue.class);
                startActivity(goToSettings);
            }
        });
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
}
