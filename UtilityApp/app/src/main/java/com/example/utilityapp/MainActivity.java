package com.example.utilityapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.utilityapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentCall = new Intent(Intent.ACTION_DIAL);
               intentCall.setData(Uri.parse("tel:766940821"));
             //  if (intentCall == null){
                   Log.i("MAINACTIVITY", "empty " + intentCall);
              // }
                startActivity(intentCall);
            }
        });
        Button btnSms = (Button) findViewById(R.id.btnSms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentSms = new Intent(Intent.ACTION_SENDTO);
                intentSms.setData(Uri.parse("smsto:" + Uri.encode("771000830")));
                intentSms.putExtra("sms_body","hello");
                startActivity(intentSms);
            }
        });

        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                startActivity(intentWeb);
            }
        });
        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = String.format("geo:38.899533,-77.036476");
                Uri geo = Uri.parse(geoUri);
                Intent intentMap = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(intentMap);
            }
        });

    }
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intentText = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intentText.putExtra(EXTRA_MESSAGE, message);
        startActivity(intentText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.action_help){

            Intent intentHelp = new Intent(getApplicationContext(), Help.class);
            startActivity(intentHelp);
        }

        return super.onOptionsItemSelected(item);
    }
}
