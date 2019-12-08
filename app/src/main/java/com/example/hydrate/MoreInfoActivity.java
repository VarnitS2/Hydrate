package com.example.hydrate;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MoreInfoActivity extends AppCompatActivity {
    private TextView buildingNameMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        String markerTitle = intent.getStringExtra("markerTitle");
        //int garbage = intent.getIntExtra("markerTitle", -1);
        buildingNameMoreInfo = findViewById(R.id.buildingNameMoreInfo);
        System.out.println("MARKER TITLE:" + markerTitle);
        buildingNameMoreInfo.setText(markerTitle);
    }
}
