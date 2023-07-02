package com.example.onlineexamapplyplatform.service;

import static com.example.onlineexamapplyplatform.util.DBHelper.COLUMN_EMAIL_ADDRESS;
import static com.example.onlineexamapplyplatform.util.DBHelper.COLUMN_PASSWORD;
import static com.example.onlineexamapplyplatform.util.DBHelper.COLUMN_USERNAME;
import static com.example.onlineexamapplyplatform.util.DBHelper.MEMBER_DETAILS_TABLE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.onlineexamapplyplatform.MainActivity;
import com.example.onlineexamapplyplatform.dto.Member;
import com.example.onlineexamapplyplatform.util.DBHelper;

public class AuthService {

    public boolean checkMemberLoginCredentials(Member memberDTO, Context context) throws Exception {
        try {
            SQLiteDatabase db = (new DBHelper(context)).getReadableDatabase();
            String sql = "SELECT * FROM " + MEMBER_DETAILS_TABLE + " WHERE USERNAME = '"+memberDTO.getUsername()+"' OR EMAIL_ADDRESS = '"+memberDTO.getMemberEmail()+"'";

            Cursor cursor = db.rawQuery(sql, null);
            String memberPassword = null;

            if (cursor.moveToFirst()) {
                do {
                    memberPassword = cursor.getString(3);
                } while (cursor.moveToNext());
            }

            cursor.close();

            if (memberPassword.equals(memberDTO.getPassword())) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("There is an Error Occur" + e.getMessage());
        }
    }

    public boolean registerNewMemberDetails(Member memberDTO, Context context) {

        SQLiteDatabase db = (new DBHelper(context)).getWritableDatabase();
        ContentValues memberValues = new ContentValues();

        memberValues.put(COLUMN_USERNAME, memberDTO.getUsername());
        memberValues.put(COLUMN_EMAIL_ADDRESS, memberDTO.getMemberEmail());
        memberValues.put(COLUMN_PASSWORD, memberDTO.getPassword());

        long insert = db.insert(MEMBER_DETAILS_TABLE, null, memberValues);

        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
}
