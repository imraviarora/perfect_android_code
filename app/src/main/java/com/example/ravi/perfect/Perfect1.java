package com.example.ravi.perfect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class Perfect1 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfect1);
        Thread th=new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch (Exception e){
                    System.out.println("Error Occured : "+e);
                }finally {
                    Intent intent=new Intent("android.intent.action.MAIN");
                    startActivity(intent);
                }
            }
        };th.start();
    }
}
