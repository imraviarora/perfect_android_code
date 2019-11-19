package com.example.ravi.perfect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Spinnerr extends Activity {
    String country[]={"India","USA","UK","Russia","China","Canada","Australia","Japan"};
    TextView textViewforspinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinnerr);
        Spinner spinnercountry=findViewById(R.id.spinnercountry);
        textViewforspinner=findViewById(R.id.tvforspinner);
        ArrayAdapter<String> adapterforspinner=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,country);
        adapterforspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercountry.setAdapter(adapterforspinner);

        spinnercountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),country[i], Toast.LENGTH_SHORT).show();
                textViewforspinner.setText("You Selected : "+country[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Spinnerr.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
