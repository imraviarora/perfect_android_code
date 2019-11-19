package com.example.ravi.perfect;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Report extends AppCompatActivity implements View.OnClickListener{
    private EditText fromDateEtxt;
    private EditText toDateEtxt;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    Button exportbutton;
    CheckBox selectall,callsummary,missedcallrep,outgoingcallrep,incomingcallrep,timeslots;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_lay);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        initialize();
        setDateTimeField();

        exportbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectall.isChecked()) {
                    StringBuilder builder=new StringBuilder();

                    callsummary.setChecked(true);
                    builder.append("Call Summary");
                    missedcallrep.setChecked(true);
                    builder.append("\nMissed Call Report");
                    outgoingcallrep.setChecked(true);
                    builder.append("\nOutgoing Call Report");
                    incomingcallrep.setChecked(true);
                    builder.append("\nIncoming Call Report");
                    timeslots.setChecked(true);
                    builder.append("\nTime Slots");

                    Toast.makeText(Report.this, builder, Toast.LENGTH_SHORT).show();
                }else {
                    StringBuilder builder=new StringBuilder();
                    if (callsummary.isChecked()){   builder.append("Call Summary"); }
                    if (missedcallrep.isChecked()){ builder.append("\nMissed Call Report");}
                    if (outgoingcallrep.isChecked()){ builder.append("\nOutgoing Call Report");}
                    if (incomingcallrep.isChecked()){ builder.append("\nIncoming Call Report");}
                    if (timeslots.isChecked()){ builder.append("\nTime Slots");}

                    Toast.makeText(Report.this, builder, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void initialize() {

        fromDateEtxt = (EditText) findViewById(R.id.etstartdate);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();

        toDateEtxt = (EditText) findViewById(R.id.etenddate);
        toDateEtxt.setInputType(InputType.TYPE_NULL);

        exportbutton=findViewById(R.id.buttonexportreport);

        selectall=findViewById(R.id.cbSelectAll);
        callsummary=findViewById(R.id.cbCallSummary);
        missedcallrep=findViewById(R.id.cbMissedcallreport);
        outgoingcallrep=findViewById(R.id.cbOutgoingcallreport);
        incomingcallrep=findViewById(R.id.cbIncomingcallreport);
        timeslots=findViewById(R.id.cbTimeslots);
    }

    private void setDateTimeField() {
        fromDateEtxt.setOnClickListener(this);
        toDateEtxt.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onClick(View view) {
        if(view == fromDateEtxt) {
            fromDatePickerDialog.show();
        } else if(view == toDateEtxt) {
            toDatePickerDialog.show();
        }
    }
}

