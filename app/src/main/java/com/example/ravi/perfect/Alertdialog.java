package com.example.ravi.perfect;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Alertdialog extends Activity {

    Button buttonclose;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialog);
        builder=new AlertDialog.Builder(this);
        buttonclose=findViewById(R.id.bclosefordialog);
        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Do You Really Want To Close ??");
                builder.setCancelable(false);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Toast.makeText(getApplicationContext(),"You Choose Yess Option",Toast.LENGTH_LONG).show();
                        finish();

                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(getApplicationContext(),"You Choose No Option",Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog alert=builder.create();
                alert.setTitle("Perfect Dialog Box");
                alert.show();
            }
        });
    }
}
