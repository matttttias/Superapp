package com.example.mattias.maj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView focusCard,sleepCard,fortyfiveCard,fifteenCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        focusCard = (CardView) findViewById(R.id.focus_card);
        sleepCard = (CardView) findViewById(R.id.sleep_card);
        fortyfiveCard = (CardView) findViewById(R.id.fortyfive_card);
        fifteenCard = (CardView) findViewById(R.id.fifteen_card);

        focusCard.setOnClickListener(this);
        sleepCard.setOnClickListener(this);
        fortyfiveCard.setOnClickListener(this);
        fifteenCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i ;
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        switch (v.getId()){
            case R.id.focus_card : i = new Intent(this,firstmenu.class);startActivity(i); break;
            case R.id.sleep_card : i = new Intent(this,sleep.class);startActivity(i); break;
            case R.id.fortyfive_card : i = new Intent(this,fortyfive.class);startActivity(i); break;
            case R.id.fifteen_card : i = new Intent(this,fifteen.class);startActivity(i); break;
            default:break;
    }
}}
