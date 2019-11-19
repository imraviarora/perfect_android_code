package com.example.ravi.perfect.BottomNvgView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.ravi.perfect.R;


public class BottomNvgview extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnvgview);
        BottomNavigationView bottomNav=findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragement=null;
                switch (item.getItemId()){
                    case R.id.bnhome:
                        selectedFragement=new BottonNvgHome();
                        break;
                    case R.id.bnsettings:
                        selectedFragement=new BottonNvgSettings();
                        break;
                    case R.id.bntrans:
                        selectedFragement=new BottonNvgTransactions();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragement).commit();

                return true;
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BottonNvgHome()).commit();
    }

}
