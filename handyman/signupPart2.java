package com.example.handyman;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class signupPart2 extends AppCompatActivity {

    private ListView listViewServices;
    private Button buttonSignUp;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_part2);


        listViewServices = findViewById(R.id.listViewServices);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonLogin = findViewById(R.id.buttonLogin3);


        ArrayList<String> items = new ArrayList<>();
        items.add("Service 1");
        items.add("Service 2");
        items.add("Service 3");


            // Create an ArrayAdapter
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, items);

            // Set the adapter to the ListView
            listViewServices.setAdapter(adapter);

            // Set choice mode to multiple
            listViewServices.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);




        Intent intent = getIntent();
        String userType=intent.getStringExtra("userType");
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        String contact = intent.getStringExtra("contact");

        if(userType.toString().equals("I'm a Handyman")){
            listViewServices.setVisibility(View.VISIBLE);
            listViewServices.setActivated(true);
        }
        else {
            listViewServices.setVisibility(View.GONE);
            listViewServices.setActivated(false);
        }





        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Handle button click action
             if(listViewServices.isActivated()){
            String getAllCheckedItems="";

                SparseBooleanArray checked = listViewServices.getCheckedItemPositions();
                for (int i = 0; i < checked.size(); i++) {
                    int position = checked.keyAt(i);
                    if (checked.valueAt(i)) {
                        if(getAllCheckedItems.toString().equals("")){
                            getAllCheckedItems = (String) listViewServices.getAdapter().getItem(position);
                        }
                        else {
                            getAllCheckedItems +=","+ (String) listViewServices.getAdapter().getItem(position);

                        }

                    }
                }


                Toast.makeText(signupPart2.this, getAllCheckedItems, Toast.LENGTH_SHORT).show();

              }
             else {
                 Toast.makeText(signupPart2.this, "", Toast.LENGTH_SHORT).show();
             }

            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i=new Intent(signupPart2.this, Login.class);
                intent.putExtra("userType", userType.toString());
                startActivity(i);
                // Handle button click action
            }
        });
    }
}



