package com.example.ravi.perfect;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;


public class Autocompletetext extends Activity {
    String lang[]={"c and c++","java","android","scala","html","css","xml","python","swift","kotlin","javascript","php","ruby","c#","rust","sql"};
    Button exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocompletedtext);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,lang);

        AutoCompleteTextView actv=findViewById(R.id.actv);
        actv.setThreshold(1);
        actv.setAdapter(arrayAdapter);

        exit=findViewById(R.id.buttonexitonactv);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
