package com.example.federico.myuni;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class Homepage extends AppCompatActivity {

    String MY_PREFERENCES ="DatiUser";

    SharedPreferences.Editor editor;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        FloatingActionButton btnSchedule= (FloatingActionButton) findViewById(R.id.imageButton2);
        FloatingActionButton btnGraphics= (FloatingActionButton) findViewById(R.id.imageButton);
        FloatingActionButton btnExam= (FloatingActionButton) findViewById(R.id.imageButton3);
        FloatingActionButton btnUser = (FloatingActionButton) findViewById(R.id.imageButton4);
        TextView txtNome= (TextView) findViewById(R.id.textView);
        TextView txtCognome=(TextView) findViewById(R.id.textView2);


        prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        editor = prefs.edit();


        txtCognome.setText(prefs.getString("cognome", "null"));
        txtNome.setText(prefs.getString("nome", "null"));

        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Bottone orario
                Intent i = new Intent(Homepage.this,Orario.class);
                startActivity(i);

            }
        });

        btnGraphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Bottone grafici dei voti
            }
        });

        btnExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Bottone esami

            }
        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.clear();
                editor.commit();
                Intent i = new Intent(Homepage.this,FirstRegistration.class);
                startActivity(i);

            }
        });
    }
}
