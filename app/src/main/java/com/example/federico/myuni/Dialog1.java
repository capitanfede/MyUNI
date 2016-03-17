package com.example.federico.myuni;





import android.annotation.TargetApi;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Dialog1 extends DialogFragment {
    LayoutInflater inflater;
    View view;
    EditText txtInsertExam;
    TextView txtInsertDate;
    TextView txtNameExam;
    TextView txtDate;
    TextView txtHour;
    Button btnSalva;
    Intent intentCalendar,intentCalendar2; // il primo va nel calendar passondo dei dati il secondo ci va senza passare dati
    TimePicker time;
    Button btnAnnulla;


    public  int day,month,year;
    public String ora = "",minuto = "",giorno,mese,anno;
    public int min3,ora3;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater=getActivity().getLayoutInflater();
        view=inflater.inflate(R.layout.activity_dialog, null);

        txtInsertExam=(EditText) view.findViewById(R.id.insertText);
        txtNameExam= (TextView) view.findViewById(R.id.nomeText);
        txtDate= (TextView) view.findViewById(R.id.dateText);
        txtHour=(TextView) view.findViewById(R.id.hourText);
        intentCalendar=new Intent(getActivity(), Calendar.class);
        intentCalendar2=new Intent(getActivity(), Calendar.class);
        txtInsertDate=(TextView) view.findViewById(R.id.insertDateText);
        btnSalva=(Button) view.findViewById(R.id.saveButton);
        time=(TimePicker) view.findViewById(R.id.timePicker);
        btnAnnulla=(Button) view.findViewById(R.id.buttonAnnulla);

        Bundle bundle =getArguments();
        day = bundle.getInt("data");
        month = bundle.getInt("month");
        year = bundle.getInt("year");

        giorno= String.valueOf(day);
        mese= String.valueOf(month);
        anno= String.valueOf(year);
        txtInsertDate.setText(day+"/"+month+"/"+year);
        intentCalendar.putExtra("giorno", giorno);
        intentCalendar.putExtra("mese",mese);
        intentCalendar.putExtra("anno",anno);


        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                insertHour(hourOfDay);
                insertMinut(minute);


            }

        });


        btnSalva.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(23)
            public void onClick(View v) {

                if((minuto.isEmpty())||(ora.isEmpty())) {
                    min3=time.getCurrentMinute();
                    ora3=time.getCurrentHour();
                    insertMinut(min3);
                    insertHour(ora3);

                }
                else if(txtInsertExam.getText().toString().isEmpty()){

                    Toast.makeText(getActivity(),"inserire nome dell'esame",Toast.LENGTH_LONG).show();

                }
                else {
                    insertEvent();
                    startActivity(intentCalendar);
                }

            }
        });


        btnAnnulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCalendar2);
            }
        });



        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("          NUOVO EVENTO");
        builder.setView(view);
        return builder.create();

    }





    public String insertEvent(){


        String nome = txtInsertExam.getText().toString(); //salva il nome dell esame inserito nell editText
        intentCalendar.putExtra("esame",nome);


        return nome;
    }



    public void insertMinut(int min){
        minuto = String.valueOf(min);
        intentCalendar.putExtra("minuto", minuto);
    }



    public void insertHour(int ora2){
        ora = String.valueOf(ora2);
        intentCalendar.putExtra("ora", ora);
    }





}
