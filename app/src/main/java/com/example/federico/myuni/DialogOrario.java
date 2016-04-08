package com.example.federico.myuni;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

public class DialogOrario extends DialogFragment {


    LayoutInflater inflater;
    View view;
    public  String esame;
    public  int day;
    public String materiaS;
    public Intent intent;

    EditText materia;
    Integer oraI, minutiI, oraF, minutiF;
    TimePicker oraInizio, oraFine;
    Orario orario;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater=getActivity().getLayoutInflater();
        view=inflater.inflate(R.layout.activity_dialog_orario, null);

        intent=new Intent(getActivity(), Calendar.class);

        Button okBtn = (Button) view.findViewById(R.id.okButton);
        materia = (EditText) view.findViewById(R.id.materiaET);
        oraInizio = (TimePicker) view.findViewById(R.id.tpInizio);
        oraFine = (TimePicker) view.findViewById(R.id.tpFine);


        String response = insertEvent();


        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setView(view);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendData();
            }
        });

        return builder.create();
    }

    public String insertEvent(){

        String nome = "Dialog eseguito e terminato"; //salva il nome dell esame inserito nell editText

        return nome;
    }

    private void sendData(){
        materiaS = materia.getText().toString();
        oraI = oraInizio.getCurrentHour();
        minutiI = oraInizio.getCurrentMinute();
        oraF = oraFine.getCurrentHour();
        minutiF = oraFine.getCurrentMinute();
        //Log.w("Fede:", ""+materiaS+" ora inizio"+oraI+":"+minutiI+" orafine "+oraF+":"+minutiF);
        dismiss();

    }

}
