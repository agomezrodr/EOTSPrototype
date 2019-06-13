package edu.utep.cs.cs4330.eotsprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class LogIn extends AppCompatActivity{
    EditText username;
    EditText passw;
    Button logIn;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        passw = (EditText) findViewById(R.id.password);
        logIn = (Button) findViewById(R.id.login);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logInIntent = new Intent(LogIn.this, MainActivity.class);
                startActivity(logInIntent);
            }
        });


        register = (TextView) findViewById(R.id.notreg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LogIn.this, Register.class);
                startActivity(registerIntent);
            }
        });
    }

}
