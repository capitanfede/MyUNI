package com.example.federico.myuni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button btnSchedule= (Button) findViewById(R.id.imageButton);
        Button btnGraphics= (Button) findViewById(R.id.imageButton2);
        Button btnExam= (Button) findViewById(R.id.imageButton3);

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
