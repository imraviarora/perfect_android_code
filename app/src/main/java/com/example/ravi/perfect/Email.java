package com.example.ravi.perfect;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Email extends Activity {
    EditText too,nme,sbjct,msg,prfsn,tme;
    String to,name,subject,message,proffesn,time;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initialize();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertedittexttostring();
                String messsage="Hello "
                        +too
                        +"  My name is "+name
                        +"  This mail  is about"+subject
                        +"  I am a "+proffesn
                        +"  Now Time is "+time
                        +"  Message is "+message;
                Toast.makeText(getApplicationContext(),messsage,Toast.LENGTH_LONG).show();
            }
        });

    }

    public void initialize(){
        too=findViewById(R.id.editTextEmail);
        nme=findViewById(R.id.editTextName);
        sbjct=findViewById(R.id.editTextSubject);
        prfsn=findViewById(R.id.editTextProffesion);
        tme=findViewById(R.id.editTextTime);
        msg=findViewById(R.id.editTexMessage);
        send=findViewById(R.id.buttonSendMail);
    }

    public void convertedittexttostring(){
        to=too.getText().toString();
        name=nme.getText().toString();
        subject=sbjct.getText().toString();
        message=msg.getText().toString();
        proffesn=prfsn.getText().toString();
        time=tme.getText().toString();
    }
}
