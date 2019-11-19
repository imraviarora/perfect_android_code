package com.example.ravi.perfect;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Perfect extends Activity{
    Button buttonTry;
    ToggleButton tgPassword;
    TextView textViewPerfect;
    EditText editTextPerfect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfect);
        buttonTry=findViewById(R.id.buttonPerfect);
        tgPassword=findViewById(R.id.toggleButtonPerfect);
        textViewPerfect=findViewById(R.id.textViewPerfect);
        editTextPerfect=findViewById(R.id.editTextPerfect);

        tgPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tgPassword.isChecked()){
                    editTextPerfect.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    //A password field with the password visible to the user
                }
                else{
                    editTextPerfect.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });

        buttonTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check=editTextPerfect.getText().toString();
                if(check.contains("left")){
                    textViewPerfect.setGravity(Gravity.LEFT);
                }else if(check.contains("right")){
                    textViewPerfect.setGravity(Gravity.RIGHT);

                }else if(check.contains("center")){
                    textViewPerfect.setGravity(Gravity.CENTER);
                }else{
                    textViewPerfect.setText("INVALID");
                }

            }
        });
    }
}
