package edu.utep.cs.cs4330.eotsprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Location extends AppCompatActivity {

    private Button currentLoc, enterLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        this.setTitle("Location");

        currentLoc = findViewById(R.id.curLocationButton);
        enterLoc = findViewById(R.id.enterLocationButton);

        currentLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Location.this, SeeLocation.class);
                startActivity(i);
            }
        });
        enterLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
