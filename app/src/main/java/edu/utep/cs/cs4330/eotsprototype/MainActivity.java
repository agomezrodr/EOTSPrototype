package edu.utep.cs.cs4330.eotsprototype;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button genReport, panic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genReport = findViewById(R.id.genRepButton);
        panic = findViewById(R.id.panButton);

        genReport.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewM.class);
                startActivity(i);
            }
        });
        panic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, ReportSubmitted .class);
//                startActivity(i);
            }
        });
//        viewReport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent j = new Intent(MainActivity.this, ViewM.class);
//                startActivity(j);
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }
    //menu at main windows
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id == R.id.instructions) {
            instructions();
            return true;
        }
        if (id == R.id.profile) {
            profile();
            return true;
        }
        if (id == R.id.exit) {
            exit();
            return true;
        }
        if (id == R.id.about) {
            about();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void exit () {
        Intent i = new Intent();
        i.setData(Uri.parse(""));
        setResult(Activity.RESULT_OK, i);
        finish();
    }
    public void about () {
        Intent j = new Intent(this, About.class);
        startActivity(j);
    }
    public void profile () {
        Intent l = new Intent(this, Profile.class);
        startActivity(l);
    }
    public void instructions () {
        Intent k = new Intent(this, Instructions.class);
        this.startActivity(k);
    }
}
