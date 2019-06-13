package edu.utep.cs.cs4330.eotsprototype;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class Register extends AppCompatActivity{
    EditText name;
    EditText lastname;
    EditText username;
    EditText passw;
    TextView dob;
    RadioButton male;
    RadioButton female;
    EditText passw2;
    Button register;
    TextView login;
    RadioGroup radiogroup;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        username = (EditText) findViewById(R.id.username);
        name = (EditText) findViewById(R.id.name);
        lastname = (EditText) findViewById(R.id.lastname);
        dob = (TextView) findViewById(R.id.dob);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog dialog = new DatePickerDialog(
                            Register.this,
                            android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener,
                       year,month,day);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = month + "/" + dayOfMonth + "/" + year;
                dob.setText(date);
            }
        };

        passw = (EditText) findViewById(R.id.password);
        passw2 = (EditText) findViewById(R.id.password2);
//        male = (RadioButton) findViewById(R.id.male);
//        female = (RadioButton) findViewById(R.id.female);
        radiogroup = (RadioGroup) findViewById(R.id.group);


        register = (Button) findViewById(R.id.login);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((passw.getText().toString().length() > 0)
                        && (passw2.getText().toString().length() > 0)
                        && (name.getText().toString().length() > 0)
                        && (lastname.getText().toString().length() > 0)
                        && (dob.getText().toString().length() > 0)
                        && (username.getText().toString().length() > 0)) {
                    if (passw.getText().toString().equals(passw2.getText().toString())) {
                        if ((isStringOnlyAlphabet(name.getText().toString()))
                                && (isStringOnlyAlphabet(lastname.getText().toString()))) {
                                Intent regInIntent = new Intent(Register.this, MainActivity.class);
                                startActivity(regInIntent);

                        } else {
                            Toast.makeText(Register.this, getString(R.string.toast_name), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register.this, getString(R.string.toast_password), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Register.this, getString(R.string.toast_empty), Toast.LENGTH_SHORT).show();
                }
            }



            });
        login = (TextView) findViewById(R.id.alredy);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logInIntent = new Intent(Register.this,LogIn.class);
                startActivity(logInIntent);
            }
        });


    }
    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((str != null)
                && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }
}


