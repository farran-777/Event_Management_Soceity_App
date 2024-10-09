package com.example.eventmanagementsoceityapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PollActivity extends AppCompatActivity {

    private int votesOption1 = 0;
    private int votesOption2 = 0;
    private int votesOption3 = 0;
    private int totalVotes = 0;

    private TextView pollQuestion;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);

        pollQuestion = findViewById(R.id.pollQuestion);
        resultTextView = findViewById(R.id.resultTextView);
        pollQuestion.setText("Which event do you prefer?");

        Button buttonOption1 = findViewById(R.id.buttonOption1);
        Button buttonOption2 = findViewById(R.id.buttonOption2);
        Button buttonOption3 = findViewById(R.id.buttonOption3);

        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                castVote(1);
            }
        });

        buttonOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                castVote(2);
            }
        });

        buttonOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                castVote(3);
            }
        });
    }

    private void castVote(int option) {
        switch (option) {
            case 1:
                votesOption1++;
                break;
            case 2:
                votesOption2++;
                break;
            case 3:
                votesOption3++;
                break;
        }
        totalVotes++;
        displayResults();
    }

    private void displayResults() {
        String resultText = "Results:\n";

        if (totalVotes > 0) {
            double percentageOption1 = (votesOption1 / (double) totalVotes) * 100;
            double percentageOption2 = (votesOption2 / (double) totalVotes) * 100;
            double percentageOption3 = (votesOption3 / (double) totalVotes) * 100;

            resultText += "E-Gaming: " + String.format("%.2f", percentageOption1) + "%\n";
            resultText += "Color Day: " + String.format("%.2f", percentageOption2) + "%\n";
            resultText += "Speech Competition: " + String.format("%.2f", percentageOption3) + "%\n";
        } else {
            resultText += "No votes yet.";
        }

        resultTextView.setText(resultText);
        Toast.makeText(this, "Vote Cast!", Toast.LENGTH_SHORT).show();
    }
}
