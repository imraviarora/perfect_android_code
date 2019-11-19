package com.example.ravi.perfect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ToggleButton extends Activity {
    android.widget.ToggleButton toggleButton1,toggleButton2;
    TextView textViewfortoggle;
    Button buttonsubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.togglebutton);
        initialize();
        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append("Toggle Button 1 :  ").append(toggleButton1.getText());
                stringBuilder.append("\nToggle Button 2 :  ").append(toggleButton2.getText());
                textViewfortoggle.setText(stringBuilder);
            }
        });
    }
    public void initialize(){
        toggleButton1=findViewById(R.id.toggleButton1);
        toggleButton2=findViewById(R.id.toggleButton2);
        buttonsubmit=findViewById(R.id.buttonSubmitt);
        textViewfortoggle=findViewById(R.id.textViewForToggle);
    }
}
