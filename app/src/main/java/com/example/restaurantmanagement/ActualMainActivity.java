package com.example.restaurantmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActualMainActivity extends AppCompatActivity {

    FloatingActionButton fab_home, fab_profile, fab_new_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_main);

        fab_home = findViewById(R.id.fab_home);
        fab_profile = findViewById(R.id.fab_profile);
        fab_new_order = findViewById(R.id.fab_new_order);

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

        fab_new_order.setOnClickListener(v -> {
            NewOrder fmt = new NewOrder();
            FragmentTransaction fmtTxn = getSupportFragmentManager().beginTransaction();
            fmtTxn.replace(R.id.fragment_layout, fmt);
            fmtTxn.commit();
        });

    }
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}