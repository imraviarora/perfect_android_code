package com.example.ravi.perfect;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Addless extends Activity {
    TextView display;
    Button add,less,reset,exit;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addless);
        add=findViewById(R.id.buttonAdd);
        reset=findViewById(R.id.buttonReset);
        exit=findViewById(R.id.buttonexit);
        less=findViewById(R.id.buttonLess);
        display=findViewById(R.id.textView);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count+=1;
                display.setText("Total is :"+count);
            }
        });
        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                display.setText("Total is :"+count);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                display.setText("Total is :"+count);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
