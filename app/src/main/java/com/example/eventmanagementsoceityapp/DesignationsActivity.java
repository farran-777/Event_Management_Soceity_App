package com.example.eventmanagementsoceityapp;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.eventmanagementsoceityapp.R;

public class DesignationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_designations);

        // Get the view reference
        View designationView = findViewById(R.id.designation);

        if (designationView != null) {
            // Apply window insets to the view
            ViewCompat.setOnApplyWindowInsetsListener(designationView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        } else {
            // Handle the case where the view is not found
            throw new IllegalStateException("View with id 'designation' not found");
        }
    }
}
