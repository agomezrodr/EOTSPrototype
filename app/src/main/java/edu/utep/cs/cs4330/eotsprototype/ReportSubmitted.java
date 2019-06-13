package edu.utep.cs.cs4330.eotsprototype;

import android.app.Activity;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ReportSubmitted extends AppCompatActivity {
    EditText answer1,answer2,answer3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_submitted);
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
        if(id == R.id.survey){
            addDialog();
            return true;
        }
        if (id == R.id.instructions) {
            instructions();
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
    public void instructions () {
        Intent k = new Intent(this, Instructions.class);
        this.startActivity(k);
    }
    private void addDialog(){
        AlertDialog.Builder itemBuilder = new AlertDialog.Builder(ReportSubmitted.this);
        View itemView = getLayoutInflater().inflate(R.layout.layout_dialog,null);

        itemBuilder.setTitle("Survey");

        //inputs
        answer1 = (EditText) itemView.findViewById(R.id.a1);
        answer2 =(EditText) itemView.findViewById(R.id.a2);
        answer3 = (EditText) itemView.findViewById(R.id.a3);

        itemBuilder.setCancelable(false)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String q1 = answer1.getText().toString();
                        String q2 = answer2.getText().toString();
                        String q3 = answer3.getText().toString();
                        //  adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        itemBuilder.setView(itemView);
        AlertDialog dialog = itemBuilder.create();
        dialog.show();

    }

}
