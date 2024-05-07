package com.example.handyman;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
public class MainScreen extends AppCompatActivity {

    private RadioGroup radioGroupUserType;
    private Button buttonLogin, buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);



        // Initialize views
        radioGroupUserType = findViewById(R.id.radioGroupUserType);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignup = findViewById(R.id.buttonSignup);

        // Set OnClickListener on Login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Determine selected user type
                int selectedId = radioGroupUserType.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);

                // Check if a user type is selected
                if (selectedId == -1) {
                    // No user type selected, show a message or handle the error
                    return;
                }

                // Start LoginActivity with selected user type
                Intent intent = new Intent( MainScreen.this, Login.class);
                intent.putExtra("userType", radioButton.getText().toString());
                startActivity(intent);
            }
        });

        // Set OnClickListener on Signup button
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Determine selected user type
                int selectedId = radioGroupUserType.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);

                // Check if a user type is selected
                if (selectedId == -1) {
                    // No user type selected, show a message or handle the error
                    return;
                }

                // Start SignupActivity with selected user type
                Intent intent = new Intent(MainScreen.this, signup.class);
                intent.putExtra("userType", radioButton.getText().toString());
                startActivity(intent);
            }
        });
    }
}