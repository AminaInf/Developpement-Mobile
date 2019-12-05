package com.example.currencyconv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view){
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        Double montant = Double.parseDouble(editText3.getText().toString());
        Double result = montant * 655.957;
        Toast.makeText(getApplicationContext(),result.toString() + "FCF",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
