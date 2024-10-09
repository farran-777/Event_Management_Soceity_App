package com.example.eventmanagementsoceityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.Objects;

public class ems3 extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private CardView cardGallery, cardUpcomingEvents, cardDesignations, cardPoll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ems3);

        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        cardGallery = findViewById(R.id.card_gallery);
        cardUpcomingEvents = findViewById(R.id.card_upcoming_events);
        cardDesignations = findViewById(R.id.card_designations);
        cardPoll = findViewById(R.id.card_poll);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // Make the Navigation drawer icon always appear on the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Set click listeners for the card views
        setCardClickListeners();
    }

    private void setCardClickListeners() {
        cardGallery.setOnClickListener(v -> {
            Intent intent = new Intent(ems3.this, GalleryActivity.class);
            startActivity(intent);
        });

        cardUpcomingEvents.setOnClickListener(v -> {
            Intent intent = new Intent(ems3.this, UpcomingEventsActivity.class);
            startActivity(intent);
        });

        cardDesignations.setOnClickListener(v -> {
            Intent intent = new Intent(ems3.this, DesignationsActivity.class);
            startActivity(intent);
        });

        cardPoll.setOnClickListener(v -> {
            Intent intent = new Intent(ems3.this, PollActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
