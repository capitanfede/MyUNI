package com.example.federico.myuni;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar extends AppCompatActivity implements View.OnClickListener{

    public int giorno;
    public int mese;
    public int anno;
    public String nameExam,ora,minuto,giornoRicevuto,meseRicevuto,annoRicevuto;
    public int i=1;
    Button prova; // da cancellare


    Bundle bundleDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        final CalendarView calendar= (CalendarView) findViewById(R.id.calendar1);
        FloatingActionButton btnPlus =(FloatingActionButton)findViewById(R.id.imageButtonPlus);
        prova=(Button) findViewById(R.id.buttonProva); // da cancellare



        btnPlus.setOnClickListener(this);
        prova.setOnClickListener(this);//da cancellare

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {


                giorno = dayOfMonth;
                mese = month + 1;
                anno = year;




                Toast.makeText(getApplicationContext(), "Hai selezionato la data " + dayOfMonth + "/" + (month+1) + "/" + year, Toast.LENGTH_SHORT).show();

            }


        });





    }

    @Override
    public void onClick(View v) {

        //GESTIONE Pulsanti

        switch (v.getId()){
            case R.id.imageButtonPlus:

                if (giorno==0 ) {

                    Toast.makeText(getApplicationContext(),"SELEZIONARE LA DATA",Toast.LENGTH_LONG).show();
                }

                else {

                    Dialog1 myDialog = new Dialog1();
                    bundleDate = new Bundle();
                    // invio a dialog1 la data il mese e l anno
                    bundleDate.putInt("data", giorno);
                    bundleDate.putInt("month", mese);
                    bundleDate.putInt("year", anno);
                    myDialog.setArguments(bundleDate);
                    i = 0;
                    myDialog.show(this.getFragmentManager(), "INSERT");

                }
                break;

            case R.id.buttonProva:  // da cancellare
                Intent i=getIntent();
                nameExam=i.getStringExtra("esame");
                ora=i.getStringExtra("ora");
                minuto=i.getStringExtra("minuto");

                //Prendi i gironi

                giornoRicevuto=i.getStringExtra("giorno");
                meseRicevuto=i.getStringExtra("mese");
                annoRicevuto=i.getStringExtra("anno");
                Toast.makeText(getApplicationContext(),"ESAME:"+nameExam+" GIORNO "+giornoRicevuto+" "+meseRicevuto+" "+annoRicevuto+"  ORA "+ora+" : "+minuto,Toast.LENGTH_LONG).show();

                break;

        }


    }





}



