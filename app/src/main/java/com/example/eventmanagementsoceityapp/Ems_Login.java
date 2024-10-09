package com.example.eventmanagementsoceityapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Ems_Login extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView loginButton;

    private static final String VALID_EMAIL = "ems123@gmail.com";
    private static final String VALID_PASSWORD = "event123";
    private static final String TAG = "Ems_Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ems_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.equals(VALID_EMAIL) && password.equals(VALID_PASSWORD)) {
                // Login successful
                Toast.makeText(Ems_Login.this, "Login Successful", Toast.LENGTH_SHORT).show();

                // Start Ems3Activity
                Intent intent = new Intent(Ems_Login.this, ems3.class);
                startActivity(intent);
                finish(); // Optionally finish this activity if you don't want to return to it
            } else {
                // Login failed
                Toast.makeText(Ems_Login.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
