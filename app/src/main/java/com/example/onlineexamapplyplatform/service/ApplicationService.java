package com.example.onlineexamapplyplatform.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.onlineexamapplyplatform.dto.Application;
import com.example.onlineexamapplyplatform.util.DBHelper;
import static com.example.onlineexamapplyplatform.util.DBHelper.APPLICATION_DETAILS_TABLE;
import static com.example.onlineexamapplyplatform.util.DBHelper.COLUMN_STUDENT_ID;
import static com.example.onlineexamapplyplatform.util.DBHelper.COLUMN_YEAR;
import static com.example.onlineexamapplyplatform.util.DBHelper.COLUMN_SEMESTER;
import static com.example.onlineexamapplyplatform.util.DBHelper.COLUMN_DESCRIPTION;

public class ApplicationService {

    public boolean createNewApplication(Application application, Context context) throws Exception {
        boolean result = false;
        try {
            SQLiteDatabase db = (new DBHelper(context)).getWritableDatabase();
            ContentValues applicationData = new ContentValues();

            if (this.verifyApplicationExist(context, application.getStudentId()) == false) {
                applicationData.put(COLUMN_STUDENT_ID, application.getStudentId());
                applicationData.put(COLUMN_YEAR, application.getApplicationYear());
                applicationData.put(COLUMN_SEMESTER, application.getApplicationSemester());
                applicationData.put(COLUMN_DESCRIPTION, application.getApplicationDescription());

                long insert = db.insert(APPLICATION_DETAILS_TABLE, null, applicationData);

                if (insert == -1) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("There is an Error Occur" + e.getMessage());
        }
    }

    private boolean verifyApplicationExist(Context context, int studentId) throws Exception {
        boolean hasResult = false;
        try {
            SQLiteDatabase db = (new DBHelper(context)).getReadableDatabase();

            String sql = "SELECT * FROM " + APPLICATION_DETAILS_TABLE + " WHERE STUDENT_ID = '" + studentId + "'";
            Cursor cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()) {
                hasResult = true;
            }
        } catch (Exception e) {
            throw new Exception("Error Occured." + e.getMessage());
        }

        if (hasResult == true) {
            return true;
        } else {
            return false;
        }
    }
}
