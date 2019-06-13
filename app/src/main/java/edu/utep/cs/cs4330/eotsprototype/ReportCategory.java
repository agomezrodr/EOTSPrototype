package edu.utep.cs.cs4330.eotsprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReportCategory extends AppCompatActivity {

    private Button button1, button2, button3;
    private double lat;
    private double lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_category);

        Intent intent = getIntent();
        lat = intent.getDoubleExtra("latitud", 0);
        lon = intent.getDoubleExtra("longitud", 0);
        Toast.makeText(this, "lat " + lat, Toast.LENGTH_SHORT).show();

        button1 = findViewById(R.id.cat1button);
        button2 = findViewById(R.id.cat2button);
        button3 = findViewById(R.id.cat3button);

        button1.setOnClickListener(view -> {
            onClick(view, 1);
        });
        button2.setOnClickListener(view -> {
            onClick(view, 2);
        });
        button3.setOnClickListener(view -> {
            onClick(view, 3);
        });

    }
    public void onClick(View view, int catType){
        Intent intent = new Intent(ReportCategory.this, SelectIncident.class);
        intent.putExtra("latitud", lat);
        intent.putExtra("longitud", lon);
        intent.putExtra("catType", catType);
        startActivity(intent);
    }
}
