package com.example.airmarh.grandcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radio_gp, radio_bmi;
    private Button open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radio_gp = findViewById(R.id.radio_gp);
        radio_bmi = findViewById(R.id.radio_bmi);
        open = findViewById(R.id.button);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_gp.isChecked()){
                    Intent intent = new Intent(MainActivity.this,OpenGpCalculatorActivity.class);
                    startActivity(intent);}
                else if(radio_bmi.isChecked()){
                    Intent intent = new Intent(MainActivity.this,OpenGpCalculatorActivity.class);
                    startActivity(intent);}
                }
        });
    }
}
