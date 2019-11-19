package com.example.ravi.perfect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ravi.perfect.BottomNvgView.BottomNvgview;
import com.example.ravi.perfect.CustomList_Main.CustomListMain;
import com.example.ravi.perfect.Nvgdrw.MainNavDrw;

public class MainActivity extends AppCompatActivity {
    ListView listViewww;
    AlertDialog.Builder builder;
    public TextView display;
    SearchView searchView;
    String starray[]={"Custom ListView","Report","Addless Program","Add Background Image","Toggle Button","OrderFood","Bundle With Radio Buttons","AlertDialog","Spinner","Auto Complete Text","Rating Bar For My App","IVRGURU","SeekBar","Progress Bar","Phone Call","Menu In Android","Tabs","Navigation Drawer","Bottom Navigation"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,starray);
        listViewww.setAdapter(adapter);
        listViewww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                listitemselecteded(position);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                display.setText("");
                adapter.getFilter().filter(query);
                return false;
            }

        });
    }

    public void initialize(){
        listViewww=findViewById(R.id.listViewww);
        searchView=findViewById(R.id.searchviewmain);
        display=findViewById(R.id.textViewonmain);
        Toolbar toolbar=findViewById(R.id.toolbar11);
        setSupportActionBar(toolbar);
    }

    public void listitemselecteded(int position){
        String result = adapter.getItem(position);
        switch (result) {
            case "Addless Program":
                Intent intent = new Intent(MainActivity.this, Addless.class);
                startActivity(intent);
                break;
            case "Custom ListView":
                intent = new Intent(MainActivity.this, CustomListMain.class);
                startActivity(intent);
                break;

            case "Report":
                intent = new Intent(MainActivity.this,Report.class);
                startActivity(intent);
                break;
            case "Add Background Image":
                intent = new Intent(MainActivity.this, Backgroundimage.class);
                startActivity(intent);
            case "Toggle Button":
                intent = new Intent(MainActivity.this, ToggleButton.class);
                startActivity(intent);
                break;
            case "OrderFood":
                intent = new Intent("com.example.ravi.perfect.ORDERFOOD");
                startActivity(intent);
                break;
            case "Bundle With Radio Buttons":
                intent = new Intent(MainActivity.this, SendingBundle.class);
                startActivity(intent);
                break;
            case "AlertDialog":
                intent = new Intent(MainActivity.this, Alertdialog.class);
                startActivity(intent);
                break;
            case "Spinner":
                intent = new Intent(MainActivity.this, Spinnerr.class);
                startActivity(intent);
                break;
            case "Auto Complete Text":
                intent = new Intent(MainActivity.this, Autocompletetext.class);
                startActivity(intent);
                break;
            case "Rating Bar For My App":
                intent = new Intent(MainActivity.this, Ratingbar.class);
                startActivity(intent);
                break;
            case "IVRGURU":
                intent = new Intent(MainActivity.this, Ivrguruwebview.class);
                startActivity(intent);
                break;
            case "SeekBar":
                intent = new Intent(MainActivity.this, Seekbar.class);
                startActivity(intent);
                break;
            case "Progress Bar":
                intent = new Intent(MainActivity.this, Progressbar.class);
                startActivity(intent);
                break;

            case "Phone Call":
                intent = new Intent(MainActivity.this, Phonecall.class);
                startActivity(intent);
                break;
            case "Menu In Android":
                intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
                break;

            case "Tabs":
                intent = new Intent(MainActivity.this, MainTab.class);
                startActivity(intent);
                break;

            case "Navigation Drawer":
                intent = new Intent(MainActivity.this, MainNavDrw.class);
                startActivity(intent);
                break;
            case "Bottom Navigation":
                intent = new Intent(MainActivity.this, BottomNvgview.class);
                startActivity(intent);
                break;

            default:
                finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.popupmenuuu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.logout:
                logoutselected();
                break;
            case R.id.setting:
                Toast.makeText(this, "Settings Not Ready", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.aboutt:
                Toast.makeText(this, "This Application is made by Ravi Arora", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void logoutselected(){
        builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Logout ??");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                finish();
                Toast.makeText(getApplicationContext(),"Logout Successful",Toast.LENGTH_LONG).show();
                Intent newintent=new Intent(MainActivity.this,LoginPage.class);
                startActivity(newintent);

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(getApplicationContext(),"Good Choice",Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alert=builder.create();
        alert.setTitle("Confirm Logout ");
        alert.show();
    }

}