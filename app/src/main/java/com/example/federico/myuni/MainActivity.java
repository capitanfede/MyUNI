package com.example.federico.myuni;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    String MY_PREFERENCES ="DatiUser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        checkFirstAccess(prefs);

    }

    protected void checkFirstAccess(SharedPreferences prefs){
        if(prefs.getString("nome","nulla").toString() == "nulla"){
            Intent i = new Intent(MainActivity.this, FirstRegistration.class);
            startActivity(i);
            finish();
        }
        else{
            Intent i = new Intent(MainActivity.this,Homepage.class);
            startActivity(i);
            finish();
        }

    }
}
