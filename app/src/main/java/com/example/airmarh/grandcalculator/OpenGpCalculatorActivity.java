package com.example.airmarh.grandcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import java.util.ArrayList;

public class OpenGpCalculatorActivity extends AppCompatActivity {
    public Button calculate;
    public TableLayout table;
    public static final String EXTRA_MESSAGE = "com.example.airmarh.grandcalculator.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_gp_calculator);
        TableLayout table = findViewById(R.id.table);
        for (int i = 0; i < table.getChildCount(); i++) {
            View v = table.getChildAt(i);
            if (v instanceof TableRow) {
                TableRow row = (TableRow) v;
                for (int j = 0; j < row.getChildCount(); j++) {
                    View row_view = row.getChildAt(j);
                    if (row_view instanceof Spinner) {
                        Spinner spinner = (Spinner) row_view;
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.grade_array, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);
                    }
                }
            }
        }

        calculate = findViewById(R.id.calculate_gp);
    }
    public float calculategp(ArrayList int_grades, int c_unit, ArrayList units) {
        ArrayList<Integer> gps = new ArrayList<>();
        int c_gp = 0;
        for (int i = 0; i < int_grades.size(); i++) {
            Object spec_unit = units.get(i);
            int m = (int) spec_unit;
            Object spec_grade = int_grades.get(i);
            int n = (int) spec_grade;
            int gp = m * n;
            gps.add(gp);
        }
        for (int k = 0; k < gps.size(); k++) {
            c_gp += gps.get(k);
        }
        float gpa = c_gp / c_unit;
        return gpa;
    }
    /*public void print(View view){
        OpenGpCalculatorActivity OG = new OpenGpCalculatorActivity();
        OG.getgrades();
        OG.getunits();
        OG.calculategp();
        Intent intent = new Intent(this, GpResultActivity.class);
        String message = "Your CGP is" + gpa + " ";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/

    public ArrayList<Integer> getgrades() {
        ArrayList<String> grades = new ArrayList<>();
        ArrayList<Integer> int_grades = new ArrayList<>();
        for (int i = 0; i < table.getChildCount(); i++) {
            View vi = table.getChildAt(i);
            if (vi instanceof Spinner) {
                Spinner spinner = (Spinner) vi;
                String grade = spinner.getSelectedItem().toString();
                grades.add(grade);
            }
        }
        int score = 0;
        for (int k = 0; k < grades.size(); k++) {
            String spec_grade = grades.get(k);
            switch (spec_grade) {
                case "A":
                    score = 5;
                    break;
                case "B":
                    score = 4;
                    break;
                case "C":
                    score = 3;
                    break;
                case "D":
                    score = 2;
                    break;
                case "E":
                    score = 1;
                    break;
                case "F":
                    score = 0;
                    break;
                default:
                    break;
            }
            int_grades.add(score);
        }
        return int_grades;
    }

    public int getunits() {
        ArrayList<Integer> units = new ArrayList<>();
        int c_unit = 0;
        for (int i = 0; i < table.getChildCount(); i++) {
            View vi = table.getChildAt(i);
            if (vi instanceof TableRow) {
                TableRow _row = (TableRow) vi;
                for (int j = 0; j < _row.getChildCount(); j++) {
                    View ro_view = _row.getChildAt(j);
                    if (ro_view instanceof EditText && j == 2) {
                        EditText row_content = (EditText) ro_view;
                        String row_text = row_content.getText().toString();
                        int unit = Integer.parseInt(row_text);
                        units.add(unit);
                    }
                }
            }
        }
        for (int l = 0; l < units.size(); l++) {
            c_unit += units.get(l);
        }
        return c_unit;
    }
}