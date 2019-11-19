package com.example.ravi.perfect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SendingBundle extends Activity {
    EditText etaskquestion;
    Button buttonask,buttonaskforresult;
    TextView tvanswer;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle hand=data.getExtras();
            String hold=hand.getString("keyofcontainer");
            tvanswer.setText(hold);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendingbundle);
        initialize();
        buttonask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bag=etaskquestion.getText().toString();
                Bundle person=new Bundle();
                person.putString("keyofbag",bag);
                Intent intentsend=new Intent(SendingBundle.this,RetrieveBundle.class);
                intentsend.putExtras(person);
                startActivity(intentsend);

            }
        });

        buttonaskforresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentforresult=new Intent(SendingBundle.this,RetrieveBundle.class);
                startActivityForResult(intentforresult,0);
            }
        });



    }

    public void initialize(){
        etaskquestion=findViewById(R.id.etquestion);
        buttonask=findViewById(R.id.buttonAsk);
        tvanswer=findViewById(R.id.tvanswer);
        buttonaskforresult=findViewById(R.id.buttonAskforresult);
    }

}

