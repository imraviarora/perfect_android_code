package com.example.ravi.perfect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class OrderFood extends Activity {
    Button buttonorder;
    CheckBox cbpizza,cbburger,cbdrink,cbfries;
    TextView displayorder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderfood);
        initialize();
        buttonorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder=new StringBuilder();
                int totalamount=0;
                if (cbpizza.isChecked()){
                    stringBuilder.append("Pizza : 220");
                    totalamount+=220;
                }
                if (cbburger.isChecked()){
                    stringBuilder.append("\nBurger : 110");
                    totalamount+=110;
                }

                if (cbdrink.isChecked()){
                    stringBuilder.append("\nCold Drink : 75");
                    totalamount+=75;
                }

                if (cbfries.isChecked()){
                    stringBuilder.append("\nFrench Fries : 95");
                    totalamount+=95;
                }
                stringBuilder.append("\n\nTotal Amout To be Paid : "+totalamount);
                displayorder.setText(stringBuilder);
            }
        });
    }

    public void initialize(){
        buttonorder=findViewById(R.id.buttonfororder);
        cbburger=findViewById(R.id.checkBoxburger);
        cbpizza=findViewById(R.id.checkBoxpizza);
        cbdrink=findViewById(R.id.checkBoxdrinks);
        cbfries=findViewById(R.id.checkBoxfries);
        displayorder=findViewById(R.id.textViewfordisplayfoodorder);
    }
}



/*
package com.example.ravi.perfect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class OrderFood extends Activity {
    Button buttonorder;
    CheckBox cbpizza,cbburger,cbdrink,cbfries;
    TextView displayorder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderfood);
        initialize();
        buttonorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder=new StringBuilder();
                int totalamount=0;
                if (cbpizza.isChecked()){
                    stringBuilder.append("Pizza : 220");
                    totalamount+=220;
                }
                if (cbburger.isChecked()){
                    stringBuilder.append("\nBurger : 110");
                    totalamount+=110;
                }

                if (cbdrink.isChecked()){
                    stringBuilder.append("\nCold Drink : 75");
                    totalamount+=75;
                }

                if (cbfries.isChecked()){
                    stringBuilder.append("\nFrench Fries : 95");
                    totalamount+=95;
                }
                stringBuilder.append("\n\nTotal Amout To be Paid : "+totalamount);
                displayorder.setText(stringBuilder);
            }
        });
    }

    public void initialize(){
        buttonorder=findViewById(R.id.buttonfororder);
        cbburger=findViewById(R.id.checkBoxburger);
        cbpizza=findViewById(R.id.checkBoxpizza);
        cbdrink=findViewById(R.id.checkBoxdrinks);
        cbfries=findViewById(R.id.checkBoxfries);
        displayorder=findViewById(R.id.textViewfordisplayfoodorder);
    }
}
*/
