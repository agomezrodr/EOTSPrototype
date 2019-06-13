package edu.utep.cs.cs4330.eotsprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity{

    private Button home, reports;
    TextView scored;
    int scoreTemA = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.setTitle("My Profile");

        //reports = findViewById(R.id.reports);
        home = findViewById(R.id.home);
        scored = (TextView) findViewById(R.id.points);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void teamAOneScore(View view) {

        scoreTemA = scoreTemA + 1;
        displayForTeamA(scoreTemA);
    }


    private void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.points);
        scoreView.setText("" + score);
    }
}
