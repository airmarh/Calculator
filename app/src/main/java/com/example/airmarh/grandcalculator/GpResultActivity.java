package com.example.airmarh.grandcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GpResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_result);
        Intent intent = getIntent();
        String message = intent.getStringExtra(OpenGpCalculatorActivity.EXTRA_MESSAGE);
        TextView result = findViewById(R.id.textView2);
        result.setText(message);
    }

}



