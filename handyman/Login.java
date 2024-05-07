package com.example.handyman;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonSignup;

    private String userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignup = findViewById(R.id.buttonSignup);

        Intent i=getIntent();
        userType=i.getStringExtra("userType");

        // Set OnClickListener on the signup button
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to navigate to the signup activity
                    Intent intent = new Intent(Login.this, signup.class);
                    intent.putExtra("userType",userType.toString());
                    // Start the signup activity
                    startActivity(intent);

            }
        });

        // Set OnClickListener on the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate username and password
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(username)) {
                    editTextUsername.setError("Username cannot be empty");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    editTextPassword.setError("Password cannot be empty");
                    return;
                }


                Intent i=new Intent(Login.this, customerDashboard.class);
                i.putExtra("userType",userType.toString());
                startActivity(i);
                // Here, you can proceed with login authentication logic
            }
        });
    }
}
