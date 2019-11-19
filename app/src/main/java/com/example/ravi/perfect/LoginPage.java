package com.example.ravi.perfect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    String usrnm,pswd;
    EditText etuname,etpwd;
    Button blogin,bexit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        initialize();

        etpwd.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
               if (actionId== EditorInfo.IME_ACTION_DONE){
                   blogin.performClick();
                   return  true;
               }
                return false;
            }
        });

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonloginpressed();
            }
        });

        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void initialize(){
        etuname=findViewById(R.id.etusername);
        etpwd=findViewById(R.id.etpswrd);
        blogin=findViewById(R.id.btnlogin);
        bexit=findViewById(R.id.btnexit);
    }

    public void buttonloginpressed(){
        usrnm=etuname.getText().toString();
        pswd=etpwd.getText().toString();
        if (usrnm.isEmpty()){
            etuname.setError("Enter Username First !!");
        }else if (pswd.isEmpty()){
            etpwd.setError("Enter Passcode First !!");
        }else{
            if (usrnm.equals("imraviarora") && pswd.equals("1920")){
                finish();
                Intent intent=new Intent(LoginPage.this,MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(LoginPage.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}