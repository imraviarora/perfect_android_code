package com.example.ravi.perfect.CustomList_Main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ravi.perfect.R;
import java.util.ArrayList;
import java.util.Calendar;

public class CustomListMain extends AppCompatActivity{
    AlertDialog.Builder builder;
    EditText contactno,reason;
    Button buttonAdd;
    ArrayList<CustomListMetaData> datalist=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customlistmain);
        initialize();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nmbr,rsn,dt;
                nmbr=contactno.getText().toString();
                rsn=reason.getText().toString();
                dt=java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                CustomListMetaData data=new CustomListMetaData(nmbr,rsn,dt);
                datalist.add(data);
                display();
            }
        });
    }

    public void initialize(){
        contactno=findViewById(R.id.etcontactno);
        reason=findViewById(R.id.etreason);
        buttonAdd=findViewById(R.id.buttonadd);
    }


    public void display(){
        ListView mListView=findViewById(R.id.blocklistview);
        final CustomListAdapter blackListAdapter=new CustomListAdapter(this,R.layout.customlistpart,datalist);
        mListView.setAdapter(blackListAdapter);

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                builder=new AlertDialog.Builder(CustomListMain.this);
                builder.setMessage("Want to remove number from blacklist ??");
                builder.setCancelable(false);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        datalist.remove(position);
                        blackListAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(getApplicationContext(),"Alright", Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog alert=builder.create();
                alert.setTitle("Remove Number !! ");
                alert.show();
                return false;
            }
        });
    }

}

