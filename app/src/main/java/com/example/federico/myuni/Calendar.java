package com.example.federico.myuni;

import android.app.AlertDialog;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar extends AppCompatActivity {
    public Date dataSelezionata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        final CalendarView calendar= (CalendarView) findViewById(R.id.calendar1);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(), "Hai selezionato la data " +dayOfMonth+ "/"+month+"/"+year, Toast.LENGTH_LONG).show();

            }
        });

        ImageButton btnPlus =(ImageButton)findViewById(R.id.plusButton);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // PLUS BUTTON

                AlertDialog.Builder miaAlert = new AlertDialog.Builder(Calendar.this);
                miaAlert.setTitle("inserire esame");
                //miaAlert.setMessage("Questa è la mia prima AlertDialog");
                //EditText txtName= (EditText) findViewById(R);
                AlertDialog alert = miaAlert.create();
                alert.show();

            }
        });



    }



    public String insertEvent (String matter){ //INSERIRE LA MATERIA D'ESAME NEL CALENDARIO



        return matter;
    }
}



