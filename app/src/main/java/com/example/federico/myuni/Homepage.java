package com.example.federico.myuni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    public int prova=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        ImageButton btnSchedule= (ImageButton) findViewById(R.id.imageButton);
        ImageButton btnGraphics= (ImageButton) findViewById(R.id.imageButton2);
        ImageButton btnExam= (ImageButton) findViewById(R.id.imageButton3);
        TextView txtNome= (TextView) findViewById(R.id.textView);
        TextView txtCognome=(TextView) findViewById(R.id.textView2);
        ImageButton imageMale=(ImageButton) findViewById(R.id.imageButton3);
       //ImageButton imageFemale=(ImageButton) findViewById(R.id.imageButton4);







        txtCognome.setText("Cognome");
        txtNome.setText("Nome");
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Bottone orario


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

                //Bottono esami

            }
        });
    }
}
