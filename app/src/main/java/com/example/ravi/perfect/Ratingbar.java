package com.example.ravi.perfect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Ratingbar extends Activity {
    RatingBar ratingBar;
    Button buttonsubmit;
    TextView tvforrating;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratingbar);
        buttonsubmit=findViewById(R.id.bsubmitforratingbar);
        ratingBar=findViewById(R.id.rbformyapp);
        tvforrating=findViewById(R.id.tvforrating);
        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ratingresult=String.valueOf(ratingBar.getRating());
                Toast.makeText(Ratingbar.this,ratingresult, Toast.LENGTH_SHORT).show();
                tvforrating.setText("You Give Rating : "+ratingresult);
            }
        });

    }
}
