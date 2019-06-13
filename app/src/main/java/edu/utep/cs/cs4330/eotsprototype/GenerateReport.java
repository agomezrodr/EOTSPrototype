package edu.utep.cs.cs4330.eotsprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class GenerateReport extends AppCompatActivity {

    private Button takePicture, submitReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);
        this.setTitle("Create Report");

        takePicture = findViewById(R.id.takePictureB);
        submitReport = findViewById(R.id.submitReportB);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(GenerateReport.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.cat1));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(GenerateReport.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.cat2));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);


        Spinner mySpinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(GenerateReport.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.cat3));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);
        takePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GenerateReport.this, Picture.class);
                startActivity(i);
            }
        });

        submitReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(GenerateReport.this, ReportSubmitted.class);
                startActivity(j);
            }
        });


    }
}
