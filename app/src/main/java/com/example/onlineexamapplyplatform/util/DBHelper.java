package com.example.onlineexamapplyplatform.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    // Database Table Name Definitions
    public static final String MEMBER_DETAILS_TABLE = "MEMBER_DETAILS";
    public static final String APPLICATION_DETAILS_TABLE = "APPLICATION_DETAILS";

    //Table Column Definitions
    public static final String COLUMN_EMAIL_ADDRESS = "EMAIL_ADDRESS";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_USERNAME = "USERNAME";

    public static final String COLUMN_STUDENT_ID = "STUDENT_ID";
    public static final String COLUMN_YEAR = "YEAR";
    public static final String COLUMN_SEMESTER = "SEMESTER";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";

    public DBHelper(Context context) {
        super(context, "member.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + MEMBER_DETAILS_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_EMAIL_ADDRESS + " TEXT, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_USERNAME + " TEXT)";
        sqLiteDatabase.execSQL(createTableStatement);

        String createApplicationDetailsTable = "CREATE TABLE " + APPLICATION_DETAILS_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_STUDENT_ID + " INTEGER, " + COLUMN_YEAR + " TEXT, " + COLUMN_SEMESTER + " TEXT, " + COLUMN_DESCRIPTION + " TEXT)";
        sqLiteDatabase.execSQL(createApplicationDetailsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
