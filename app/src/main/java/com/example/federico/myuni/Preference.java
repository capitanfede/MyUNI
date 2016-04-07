package com.example.federico.myuni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Preference extends AppCompatActivity {

    EditText txtnome,txtcognome,txtmatricola;
    int appoggio=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        txtnome=(EditText)findViewById(R.id.idnome);
        txtcognome=(EditText)findViewById(R.id.idcognome);
        txtmatricola=(EditText)findViewById(R.id.idmatricola);

        txtcognome.setEnabled(false);
        txtcognome.setFocusable(false);
        txtcognome.setClickable(true);
        txtmatricola.setEnabled(false);

        if (appoggio==0) {
            txtnome.setFocusable(false);
        }
        txtnome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        /*txtnome.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                txtnome.setFocusable(true);
                Toast.makeText(getApplicationContext(), "MODIFICA NOME", Toast.LENGTH_SHORT).show();
                appoggio=1;
                return false;
            }
        });/*



        /*txtcognome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtcognome.setEnabled(true);
                txtcognome.setFocusable(true);
                txtcognome.getEditableText();
                Toast.makeText(getApplicationContext(), "MODIFICA COGNOME", Toast.LENGTH_SHORT).show();
            }
        });

        txtmatricola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "MODIFICA MATRICOLA", Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}
