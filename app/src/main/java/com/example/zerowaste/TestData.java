package com.example.zerowaste;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TestData extends AppCompatActivity {
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_data);
        test=(TextView)findViewById(R.id.tstdata);
        String name=getIntent().getStringExtra("keyEvntName");
        test.setText(name);


    }
}