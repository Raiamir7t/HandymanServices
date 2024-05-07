package com.example.handyman;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class signup extends AppCompatActivity {



    private EditText editTextName, editTextEmail, editTextPassword, editTextConfirmPassword, editTextContact;
    private Button buttonCancel, buttonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);




        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        editTextContact = findViewById(R.id.editTextContact);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonNext = findViewById(R.id.buttonNext);


        Intent i=getIntent();
        String userType=i.getStringExtra("userType");



// Show the first item by default
// Set OnClickListener on the location button


        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextName.setText("");
                editTextEmail.setText("");
                editTextPassword.setText("");
                editTextConfirmPassword.setText("");
                editTextContact.setText("");

            }
        });




        // Set OnClickListener on the location button
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validation
                if (TextUtils.isEmpty(editTextName.getText().toString())) {
                    editTextName.setError("Please enter your name");
                    return;
                }

                if (TextUtils.isEmpty(editTextEmail.getText().toString())) {
                    editTextEmail.setError("Please enter your email");
                    return;
                }

                if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
                    editTextPassword.setError("Please enter a password");
                    return;
                }

                if (TextUtils.isEmpty(editTextConfirmPassword.getText().toString())) {
                    editTextConfirmPassword.setError("Please confirm your password");
                    return;
                }

                if (!editTextPassword.getText().toString().equals(editTextConfirmPassword.getText().toString())) {
                    editTextConfirmPassword.setError("Passwords do not match");
                    return;
                }

                if (TextUtils.isEmpty(editTextContact.getText().toString())) {
                    editTextContact.setError("Please enter your contact number");
                    return;
                }


                // Perform signup logic here (e.g., send data to server)

                // Display a success message
                Toast.makeText(signup.this, "Signup successful!", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(signup.this, signupPart2.class);

                intent.putExtra("userType", userType.toString());
                intent.putExtra("name", editTextName.getText().toString());
                intent.putExtra("email", editTextEmail.getText().toString());
                intent.putExtra("password", editTextPassword.getText().toString());
                intent.putExtra("contact", editTextContact.getText().toString());
                startActivity(intent);

                // Create intent to open Google Maps
                // Start the activity for result
            }
        });
    }




}