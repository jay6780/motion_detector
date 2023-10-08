package com.m.motion_detector;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Fish_count_list extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    String[] position = {"Choose","Recent"};
    AppCompatButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_count_list);
        back = findViewById(R.id.back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            Spinner spin = findViewById(R.id.Spinner); //spinner is spinner id
            spin.setOnItemSelectedListener(this);
            //arrayadapter (set position data to arrayadapter)
            ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, position);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            //set array adapter to fill spinner
            spin.setAdapter(aa);

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),front_page.class);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    finish();
                }
            });
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position).equals("Choose")) {
            overridePendingTransition(0, 0); // Disable animation
        }
          else if (parent.getItemAtPosition(position).equals("Recent")) {
                Toast.makeText(getApplicationContext(), "Recent", Toast.LENGTH_LONG).show();
                overridePendingTransition(0, 0);
            }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void onBackPressed(){
        Intent i = new Intent(getApplicationContext(),front_page.class);
        startActivity(i);
        overridePendingTransition(0,0);
        finish();
        super.onBackPressed();
    }
}