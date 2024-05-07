package com.example.handyman;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Send_Feedback extends AppCompatActivity {

    private TextView textViewUserName, textViewRating, textViewFeedbackHeading;
    private RatingBar ratingBar;
    private EditText editTextComments;
    private Button buttonSaveFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feedback);

        textViewUserName = findViewById(R.id.textViewUserName);
        textViewRating = findViewById(R.id.textViewRating);
        textViewFeedbackHeading = findViewById(R.id.textViewFeedbackHeading);
        ratingBar = findViewById(R.id.ratingBar);
        editTextComments = findViewById(R.id.editTextComments);
        buttonSaveFeedback = findViewById(R.id.buttonSaveFeedback);

        HandyMan handyMan= (HandyMan) getIntent().getSerializableExtra("handyman");
        // Example data
        String userName = handyMan.getName();
        float rating = Float.parseFloat(String.valueOf(handyMan.getRate()));

        // Set user name and rating text
        textViewUserName.setText(userName);
        textViewRating.setText("(" + rating + ")");

        // Set rating on the RatingBar
        ratingBar.setRating(handyMan.getRating());

        // Save feedback button click listener
        buttonSaveFeedback.setOnClickListener(view -> saveFeedback());
    }

    // Method to save feedback
    private void saveFeedback() {
        String comments = editTextComments.getText().toString();
        // Example: Display a toast with the feedback comments
        Toast.makeText(this, "Feedback saved: " + comments, Toast.LENGTH_SHORT).show();
    }
}