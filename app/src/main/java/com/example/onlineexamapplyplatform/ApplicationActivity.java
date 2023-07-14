package com.example.onlineexamapplyplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineexamapplyplatform.dto.Application;
import com.example.onlineexamapplyplatform.service.ApplicationService;

public class ApplicationActivity extends AppCompatActivity {

    TextView applicationDescription;
    Button applyExamination, seeAllExamination;
    Spinner examinationYearSpn, semesterSpn;

    // Examination Year DropDownList
    String[] examinationYears = {"Year 1", "Year 2"};
    String[] semesters = {"Semester 1", "Semester 2"};

    ApplicationService applicationService = new ApplicationService();

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

    public void applyExamApplication(View view) {
        Application application = new Application();
        String applicationYear = this.examinationYearSpn.getSelectedItem().toString();
        String applicationSemester = this.semesterSpn.getSelectedItem().toString();
        applicationDescription = findViewById(R.id.applicationDescription);

        if ((applicationYear != null || applicationYear != "") && (applicationSemester != null || applicationSemester != "")) {
            application.setApplicationYear(applicationYear);
            application.setApplicationSemester(applicationSemester);
            application.setApplicationDescription(applicationDescription.getText().toString());

            try {
                if (this.applicationService.createNewApplication(application, this) == true) {
                    this.showToast(this, "Successfully.");
                } else {
                    this.showToast(this, "Error Occued.");
                }
            } catch (Exception e) {
                this.showToast(this, "Error Occued.");
            }
        } else {
            this.showToast(this, "Year & Semester Must be Filled.");
        }
    }

    public void showToast(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
    }
}