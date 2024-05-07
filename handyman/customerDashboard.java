package com.example.handyman;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
public class customerDashboard extends AppCompatActivity {


         private BottomNavigationView bottomNavigationView;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_customer_dashboard);

            bottomNavigationView = findViewById(R.id.bottomNavigationView);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    if (item.getItemId() == R.id.action_ongoing) {
                        Toast.makeText(customerDashboard.this, "Clicked", Toast.LENGTH_SHORT).show();
                        // Start ProfileActivity when "Profile" menu item is clicked
                        Fragment selectedFragment = new FragmentProfile();

                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragement,selectedFragment ).commit();
                        return true;
                    }

                    if (item.getItemId() == R.id.action_pending) {
                        Toast.makeText(customerDashboard.this, "Clicked", Toast.LENGTH_SHORT).show();
                        // Start ProfileActivity when "Profile" menu item is clicked
                        Fragment selectedFragment = new scheduleFragment();

                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragement,selectedFragment ).commit();
                        return true;
                    }

                    if (item.getItemId() == R.id.action_request) {
                        Toast.makeText(customerDashboard.this, "Clicked", Toast.LENGTH_SHORT).show();
                        // Start ProfileActivity when "Profile" menu item is clicked
                        Fragment selectedFragment = new scheduleFragment();

                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragement,selectedFragment ).commit();
                        return true;
                    }

                    if (item.getItemId() == R.id.action_home) {
                        Toast.makeText(customerDashboard.this, "Clicked", Toast.LENGTH_SHORT).show();
                        // Start ProfileActivity when "Profile" menu item is clicked
                        Fragment selectedFragment = new BlankFragment();

                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragement,selectedFragment ).commit();
                        return true;
                    }


                    if (item.getItemId() == R.id.action_schedule) {
                        Toast.makeText(customerDashboard.this, "Clicked", Toast.LENGTH_SHORT).show();
                        // Start ProfileActivity when "Profile" menu item is clicked
                        int w=0;
                        Fragment selectedFragment=null;
                        w=0;
                        selectedFragment= new scheduleFragment();
                        w=0;
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragement,selectedFragment ).commit();
                        return true;
                    }

                    return false;
                }
            });
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.newmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String title=item.getTitle().toString();
        if(title.equals("Profile")){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFragement, new FragmentProfile()) // Replace "ProfileFragment" with your actual fragment class
                    .addToBackStack(null) // Optional: Add transaction to back stack
                    .commit();
        }
        else if(title.equals("Search")){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFragement, new FragmentSearch()) // Replace "ProfileFragment" with your actual fragment class
                    .addToBackStack(null) // Optional: Add transaction to back stack
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }
}


