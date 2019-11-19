package com.example.ravi.perfect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Seekbar extends Activity {
    SeekBar seekBarobject;
    TextView textViewforseekbar,tvresult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar);
        seekBarobject=findViewById(R.id.seekBarobject);
        textViewforseekbar=findViewById(R.id.tvforseekbar);
        tvresult=findViewById(R.id.tvresultforseekbar);
        seekBarobject.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                tvresult.setText("Progress : "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Seekbar.this,"Progress Started", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Seekbar.this, "Progress Stopped", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
