package com.example.ravi.perfect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RetrieveBundle extends Activity {
    Button buttonReturn;
    TextView tvquestionis,tvansweris;
    RadioButton radioButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrievebundle);
        initialize();

 //ASK
  /*      Bundle hand=getIntent().getExtras();
        String hold=hand.getString("keyofbag");
        tvquestionis.setText(hold);*/

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            String selected;
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id){
                    case R.id.rbCrazy:
                        selected="Yess Crazy";
                        break;
                    case R.id.rbSexy:
                        selected="Wow Sexy";
                        break;
                    case R.id.rbBoth:
                        selected="OMG BOTH";
                        break;
                    default:
                        selected="NOT SELECT";
               }
               tvansweris.setText(selected);
            }
        });

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle ship=new Bundle();
                String container=tvansweris.getText().toString();
                ship.putString("keyofcontainer",container);
                Intent intentwater=new Intent(RetrieveBundle.this,SendingBundle.class);
                intentwater.putExtras(ship);
                setResult(RESULT_OK,intentwater);
                finish();
            }
        });
    }
    public  void initialize(){
        buttonReturn=findViewById(R.id.breturn);
        tvansweris=findViewById(R.id.tvansweris);
        tvquestionis=findViewById(R.id.tvquestionis);
        radioGroup=findViewById(R.id.rgoptions);

    }
}
