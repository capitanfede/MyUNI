package com.example.federico.myuni;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class Orario extends AppCompatActivity {

    ActionBarDrawerToggle toggle;
    LinearLayout mLinearLayout;
    TabLayout tabLayout;
    OrarioFragment orarioFragment;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orario);

        setTitle("Orario");
        orarioFragment = (OrarioFragment) getFragmentManager().findFragmentById(R.id.fragmentOrario);
        setTablelayout();

    }

    public void setTablelayout(){
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.lunedi));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.martedi));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.mercoledi));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.giovedi));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.venerdi));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.sabato));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                switch (position) {
                    case 0:
                        orarioFragment.setDate(getString(R.string.lunedi));
                        break;
                    case 1:
                        orarioFragment.setDate(getString(R.string.martedi));
                        break;
                    case 2:
                        orarioFragment.setDate(getString(R.string.mercoledi));
                        break;
                    case 3:
                        orarioFragment.setDate(getString(R.string.giovedi));
                        break;
                    case 4:
                        orarioFragment.setDate(getString(R.string.venerdi));
                        break;
                    case 5:
                        orarioFragment.setDate(getString(R.string.sabato));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
}
