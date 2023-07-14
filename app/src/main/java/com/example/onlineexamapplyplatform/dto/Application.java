package com.example.onlineexamapplyplatform.dto;

public class Application {

    private int id;
    private int studentId;
    private String applicationYear;
    private String applicationSemester;
    private String applicationDescription;

    public Application() {

    }

    public Application(int id, int studentId, String applicationYear, String applicationSemester, String applicationDescription) {
        this.id = id;
        this.studentId = studentId;
        this.applicationYear = applicationYear;
        this.applicationSemester = applicationSemester;
        this.applicationDescription = applicationDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getApplicationYear() {
        return applicationYear;
    }

    public void setApplicationYear(String applicationYear) {
        this.applicationYear = applicationYear;
    }

    public String getApplicationSemester() {
        return applicationSemester;
    }

    public void setApplicationSemester(String applicationSemester) {
        this.applicationSemester = applicationSemester;
    }

    public String getApplicationDescription() {
        return applicationDescription;
    }

    public void setApplicationDescription(String applicationDescription) {
        this.applicationDescription = applicationDescription;
    }
}
