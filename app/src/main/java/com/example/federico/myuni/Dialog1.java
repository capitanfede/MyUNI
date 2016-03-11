package com.example.federico.myuni;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
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
    public  String esame;
    public  int day,month,year;
    public String day2;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater=getActivity().getLayoutInflater();
        view=inflater.inflate(R.layout.activity_dialog, null);

        txtInsertExam=(EditText) view.findViewById(R.id.insertText);
        txtNameExam= (TextView) view.findViewById(R.id.nomeText);
        txtDate= (TextView) view.findViewById(R.id.dateText);


        txtInsertDate=(TextView) view.findViewById(R.id.insertDateText);
        Calendar calendarObject = new Calendar();

        Bundle bundle =getArguments();
        day = bundle.getInt("data");

        /*day = calendarObject.getDay();


        month = calendarObject.getMonth();
        year= calendarObject.getYear();*/


        Log.e("DATA LETTA", "" +day);

        //Toast.makeText(getApplicationContext(), "Data:"+day+"/"+month+"/"+year, Toast.LENGTH_LONG).show();

        //txtInsertDate.setText(day+"/"+month+"/"+year);
        txtInsertDate.setText("Ciao: " + day);


        //insertEvent();


        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setView(view);
        return builder.create();

    }

   /* public String insertEvent(){
        String nome = txtInsertExam.getText().toString();

        return nome;
    }*/


}
