package com.example.restaurantmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActualMainActivity extends AppCompatActivity {

    FloatingActionButton fab_home, fab_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_main);

        fab_home = findViewById(R.id.fab_home);
        fab_profile = findViewById(R.id.fab_profile);

        fab_home.setOnClickListener(v -> {
            HomeFragment fmt = new HomeFragment();
            FragmentTransaction fmtTxn = getSupportFragmentManager().beginTransaction();
            fmtTxn.replace(R.id.fragment_layout, fmt);
            fmtTxn.commit();
        });

        fab_profile.setOnClickListener(v -> {
            ProfileFragment fmt = new ProfileFragment();
            FragmentTransaction fmtTxn = getSupportFragmentManager().beginTransaction();
            fmtTxn.replace(R.id.fragment_layout, fmt);
            fmtTxn.commit();
        });

    }
}