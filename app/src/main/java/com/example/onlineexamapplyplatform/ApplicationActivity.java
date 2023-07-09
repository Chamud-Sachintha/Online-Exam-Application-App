package com.example.onlineexamapplyplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ApplicationActivity extends AppCompatActivity {

    Spinner examinationYearSpn, semesterSpn;

    // Examination Year DropDownList
    String[] examinationYears = {"Year 1", "Year 2"};
    String[] semesters = {"Semester 1", "Semester 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        examinationYearSpn = (Spinner) findViewById(R.id.examinationYearSpn);
        semesterSpn = (Spinner) findViewById(R.id.semesterSpinner);

        ArrayAdapter<String> examinationYearSpnAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, examinationYears);
        examinationYearSpnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        examinationYearSpn.setAdapter(examinationYearSpnAdapter);

        ArrayAdapter<String> semesterAdaptor = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, semesters);
        semesterAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSpn.setAdapter(semesterAdaptor);
    }
}