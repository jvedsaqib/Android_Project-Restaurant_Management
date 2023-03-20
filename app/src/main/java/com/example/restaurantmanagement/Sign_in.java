package com.example.restaurantmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Sign_in extends AppCompatActivity {

    FirebaseAuth mAuth;

    EditText et_email, et_password;

    Button btn_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        mAuth = FirebaseAuth.getInstance();

        btn_signin = findViewById(R.id.btn_signin);

        btn_signin.setOnClickListener(v -> {
            mAuth.signInWithEmailAndPassword(et_email.getText().toString(), et_password.getText().toString()).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    startActivity(new Intent(Sign_in.this, ActualMainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(this, task.getException().toString(), Toast.LENGTH_SHORT);
                }
            });
        });



    }
}