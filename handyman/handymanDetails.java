package com.example.handyman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;import androidx.appcompat.app.AppCompatActivity;
public class handymanDetails extends AppCompatActivity {



    EditText editTextHandymanName, editTextHandymanEmail, editTextHandymanContact, editTextHandymanRate;

    HashMap<String, List<String>> expandableListDetail;
    CustomExpandableListAdapter expandableListAdapter;

    List<String> expandableListTitle ;

    ExpandableListView expandableListView;

    RatingBar ratingBar;
    Button buttonBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handyman_details);

        // Retrieve HandyMan object from intent
        expandableListTitle = new ArrayList<>();

        HandyMan handyMan = (HandyMan) getIntent().getSerializableExtra("handyman");


        editTextHandymanName = findViewById(R.id.editTextHandymanName);
        editTextHandymanEmail = findViewById(R.id.editTextHandymanEmail);
        editTextHandymanContact = findViewById(R.id.editTextHandymanContact);
        editTextHandymanRate = findViewById(R.id.editTextHandymanRate);
        expandableListView=findViewById(R.id.expandableListViewHandymanService);
        ratingBar = findViewById(R.id.ratingBar);
        buttonBook = findViewById(R.id.buttonBook);
        // Set HandyMan object fields to EditText views
        editTextHandymanName.setText(handyMan.getName());
//        editTextHandymanEmail.setText(handyMan.getEmail());
  //      editTextHandymanContact.setText(handyMan.getContact());
        editTextHandymanRate.setText(String.valueOf(handyMan.getRate()));

        setupExpandableListView();

        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(handymanDetails.this,Send_Feedback.class);
                i.putExtra("handyman",handyMan);
                startActivity(i);
            }
        });



    }


    private void prepareExpandableListData() {
        expandableListTitle = new ArrayList<>();
        expandableListDetail = new HashMap<>();

        // Add titles and child items
        expandableListTitle.add("Group 1");
        expandableListTitle.add("Group 2");

        List<String> group1 = new ArrayList<>();
        group1.add("Item 1");
        group1.add("Item 2");
        group1.add("Item 3");

        List<String> group2 = new ArrayList<>();
        group2.add("Item 4");
        group2.add("Item 5");
        group2.add("Item 6");

        expandableListDetail.put("Group 1", group1);
        expandableListDetail.put("Group 2", group2);
    }


    private void setupExpandableListView() {
        expandableListView = findViewById(R.id.expandableListViewHandymanService);
        prepareExpandableListData();

        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);


        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // Expand the group if it is collapsed, or collapse it if it is expanded
                if (expandableListView.isGroupExpanded(groupPosition)) {
                    expandableListView.collapseGroup(groupPosition);
                } else {
                    expandableListView.expandGroup(groupPosition);
                }
                // Return true to indicate that the click was handled
                return true;
            }
        });
    }
}
