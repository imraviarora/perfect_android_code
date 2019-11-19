package com.example.ravi.perfect;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Phonecall extends Activity {
    private static final int REQUEST_CALL =1 ;
    EditText phoneno;
    Button buttoncall,bravi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phonecall);
        phoneno=findViewById(R.id.etphonecall);
        buttoncall=findViewById(R.id.bcall);
        bravi=findViewById(R.id.bcalltoravi);
        bravi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneno.setText("7206120067");
            }
        });
        buttoncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               makephonecall();
            }
        });

    }
    public  void makephonecall(){
        String number=phoneno.getText().toString();
        if(ContextCompat.checkSelfPermission(Phonecall.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Phonecall.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else {
            String dial=number;
            Intent intentcall=new Intent(Intent.ACTION_CALL);
            intentcall.setData(Uri.parse("tel:"+dial));
            startActivity(intentcall);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CALL){
            if (grantResults.length > 0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED) {
                makephonecall();
            }else {
                Toast.makeText(this,"Permission not granted",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
