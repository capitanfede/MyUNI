package com.example.federico.myuni;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    public String nameExam;
    public int i=1;


    Bundle bundleDate;
    public Bundle bundleExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        final CalendarView calendar= (CalendarView) findViewById(R.id.calendar1);
        FloatingActionButton btnPlus =(FloatingActionButton)findViewById(R.id.imageButtonPlus);

       ;

        btnPlus.setOnClickListener(this);


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {


                giorno = dayOfMonth;
                mese = month + 1;
                anno = year;


                Toast.makeText(getApplicationContext(), "Hai selezionato la data " + giorno + "/" + mese + "/" + anno, Toast.LENGTH_SHORT).show();

            }


        });

        Toast.makeText(getApplicationContext(),"sono qua",Toast.LENGTH_LONG);
        receptionExam();


    }

    @Override
    public void onClick(View v) {

        //GESTIONE POPUP

        switch (v.getId()){
            case R.id.imageButtonPlus:
                Dialog1 myDialog=new Dialog1();
                bundleDate= new Bundle();

                bundleDate.putInt("data", giorno);
                bundleDate.putInt("month",mese);
                bundleDate.putInt("year",anno);
                myDialog.setArguments(bundleDate);
                i=0;

                //myDialog.setArguments(bundleMonth);
                //myDialog.setArguments(bundleYear);
                myDialog.show(this.getFragmentManager(), "INSERT");

                break;
        }
    }


    public String receptionExam(){ //NOME DEL ESAME


        Intent i=getIntent();
        nameExam=i.getStringExtra("esame");
        Log.e("ESAME:",nameExam);
        Toast.makeText(getApplicationContext(),"ESAME:"+nameExam,Toast.LENGTH_LONG);


        return nameExam;
    }


}



