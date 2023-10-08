package com.m.motion_detector;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class CountAct extends AppCompatActivity {
    ImageView counts;
    AppCompatButton cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        counts = findViewById(R.id.img);
        cancel = findViewById(R.id.cancel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

          counts.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent i = new Intent(getApplicationContext(),Fish_count_list.class);
                  startActivity(i);
                  finish();
                  overridePendingTransition(0,0);

              }
          });

          cancel.setOnClickListener(new View.OnClickListener() {
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
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), front_page.class);
        startActivity(i);
        overridePendingTransition(0, 0);
        finish();
        super.onBackPressed();
    }
}