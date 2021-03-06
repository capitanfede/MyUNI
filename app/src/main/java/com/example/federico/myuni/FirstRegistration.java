package com.example.federico.myuni;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstRegistration extends AppCompatActivity {

    EditText nome, cognome, universita, cfu;
    TextView test;
    String nomeS, cognomeS, universitaS;
    Integer cfuI;
    String MY_PREFERENCES ="DatiUser";

    SharedPreferences.Editor editor;
    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_registration);

        nome = (EditText) findViewById(R.id.nomeET);
        cognome = (EditText) findViewById(R.id.cognomeET);
        universita = (EditText) findViewById(R.id.facoltaET);
        cfu = (EditText) findViewById(R.id.cfuET);

        prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        editor = prefs.edit();

        FloatingActionButton okButton = (FloatingActionButton) findViewById(R.id.okButton);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cfu.getText().toString().equals("") || nome.getText().toString().equals("")
                        || cognome.getText().toString().equals("") || universita.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(), "Completa tutti i campi", Toast.LENGTH_SHORT).show();
                }

                else{
                    setSharedPreferences();
                    Intent i = new Intent(FirstRegistration.this, Homepage.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        }

        void setSharedPreferences(){

            nomeS = nome.getText().toString();
            cognomeS = cognome.getText().toString();
            universitaS = universita.getText().toString();
            cfuI = Integer.parseInt(cfu.getText().toString());

            editor.putString("nome", nomeS);
            editor.putString("cognome", cognomeS);
            editor.putString("univesita", universitaS);
            editor.putInt("cfu", cfuI);
            editor.commit();


        }

    }
