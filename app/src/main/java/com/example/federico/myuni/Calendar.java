package com.example.federico.myuni;

import android.app.AlertDialog;
import android.media.Image;
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

    Bundle bundleDate;
    public Bundle bundleExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        final CalendarView calendar= (CalendarView) findViewById(R.id.calendar1);
        ImageButton btnPlus =(ImageButton)findViewById(R.id.plusButton);

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



    }

    @Override
    public void onClick(View v) {

        //GESTIONE POPUP

        switch (v.getId()){
            case R.id.plusButton:
                Dialog1 myDialog=new Dialog1();
                bundleDate= new Bundle();

                bundleDate.putInt("data", giorno);
                bundleDate.putInt("month",mese);
                bundleDate.putInt("year",anno);
                myDialog.setArguments(bundleDate);

                //myDialog.setArguments(bundleMonth);
                //myDialog.setArguments(bundleYear);
                myDialog.show(this.getFragmentManager(), "INSERT");

                break;
        }
    }


    public String receptionExam(){ //NOME DEL ESAME





        return nameExam;
    }


}



