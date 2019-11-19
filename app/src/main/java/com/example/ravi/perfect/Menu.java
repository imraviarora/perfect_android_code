package com.example.ravi.perfect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;


public class Menu extends AppCompatActivity {
    Button buttonpop;
    String frndznames[]={"Ravi Arora","Aman Hasija","Vaibhav Dhamiwal","Bhavnesh Dhamija","Amit Chhabra","Aakash Sharma"};
    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        listView=findViewById(R.id.listvieww);
        buttonpop=findViewById(R.id.buttonpopupmenu);
        buttonpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(Menu.this,buttonpop);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenuuu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(Menu.this, "Hey", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(Menu.this, "You Clicked on "+menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        });
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,frndznames);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.cool_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu,menu);
        menu.setHeaderTitle("Choose :");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.contextcall:
                Toast.makeText(this, "Calling...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextsms:
                Toast.makeText(this, "Sending...", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}