package com.example.federico.myuni;


import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class OrarioFragment extends Fragment {

    FloatingActionButton addButton;
    String currentDay;
    Intent i;

    private View myFragmentView;

    public OrarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myFragmentView = inflater.inflate(R.layout.fragment_orario, container, false);
        addButton = (FloatingActionButton) myFragmentView.findViewById(R.id.plusButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog(currentDay);
            }
        });

        return myFragmentView;

    }

    public void setDate(String giorno){
        currentDay = giorno;

    }

    private void openDialog(String giorno){
        DialogOrario myDialog=new DialogOrario();

        myDialog.show(this.getFragmentManager(), "Inserisci lezione");

    }


}
