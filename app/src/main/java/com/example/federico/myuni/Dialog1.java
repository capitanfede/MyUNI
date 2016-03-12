package com.example.federico.myuni;



/*
SALVARE TUTTI I DATI INSERITI NEL DIALOG NEL DATABASE COSI POI NEL CALENDAR.JAVA SI VANNO
A PRENDERE I DATI DAL DATABASE E SCRITTI NEL FRAGMENT.
*/



import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dialog1 extends DialogFragment {
    LayoutInflater inflater;
    View view;
    EditText txtInsertExam;
    TextView txtInsertDate;
    TextView txtNameExam;
    TextView txtDate;
    TextView txtHour;
    public  String esame;
    public  int day,month,year;
    public String day2;
    public Intent intent;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater=getActivity().getLayoutInflater();
        view=inflater.inflate(R.layout.activity_dialog, null);

        txtInsertExam=(EditText) view.findViewById(R.id.insertText);
        txtNameExam= (TextView) view.findViewById(R.id.nomeText);
        txtDate= (TextView) view.findViewById(R.id.dateText);
        txtHour=(TextView) view.findViewById(R.id.hourText);
        intent=new Intent(getActivity(), Calendar.class);


        txtInsertDate=(TextView) view.findViewById(R.id.insertDateText);

        Bundle bundle =getArguments();
        day = bundle.getInt("data");
        month = bundle.getInt("month");
        year = bundle.getInt("year");


        txtInsertDate.setText(day+"/"+month+"/"+year);



        insertEvent();


        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setView(view);
        return builder.create();

    }

    public String insertEvent(){

        String nome = txtInsertExam.getText().toString(); //salva il nome dell esame inserito nell editText
        
        return nome;
    }




}
