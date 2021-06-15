package com.example.basic_banking_app.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserHelper extends SQLiteOpenHelper {
    String TABLE_NAME = User_Contact.UserEntry.TABLE_NAME;
    private static String DATABASE_NAME = "User.db";
    private static int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + User_Contact.UserEntry.TABLE_NAME + " ("
                + User_Contact.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + User_Contact.UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + User_Contact.UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + User_Contact.UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + User_Contact.UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + User_Contact.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_USER_TABLE);
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Tarun Prakash', 'tarun@gmail.com','7584','7895641238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7460,'Prakash Raj', 'prakash@gmail.com','7585','7895641232', 1500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7260,'Anand Kumar', 'anand@gmail.com','7586','7895641233', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7160,'Aman Saini', 'saini@gmail.com','7587','7895691218', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7810,'Subham Anand', 'subham@gmail.com','7588','7897641238', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7420,'Aman Kumar', 'aman@gmail.com','7589','7895641132', 1500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7230,'Anand Kumar', 'akumar@gmail.com','8584','7595641233', 12000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7140,'Aman Saini', 'amansainiq@gmail.com','8585','7395641218', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7850,'Parth Dutta', 'parth@gmail.com','8586','7891641238', 13000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7470,'Ankush Singh', 'singh@gmail.com','8587','7595641232', 1500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7280,'Anand Kumar', 'aman@gmail.com','8588','7695641233', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7190,'Aman Saini', 'sainiq@gmail.com','8589','7795641218', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Tarun Prakash', 'tarun@gmail.com','7584','7895641238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7460,'Prakash Raj', 'prakash@gmail.com','7585','7895641232', 1500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7260,'Anand Kumar', 'anand@gmail.com','7586','7895641233', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7160,'Aman Saini', 'saini@gmail.com','7587','7895691218', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7810,'Subham Anand', 'subham@gmail.com','7588','7897641238', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7420,'Aman Kumar', 'aman@gmail.com','7589','7895641132', 1500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7230,'Anand Kumar', 'akumar@gmail.com','8584','7595641233', 12000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7140,'Aman Saini', 'amansainiq@gmail.com','8585','7395641218', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7850,'Parth Dutta', 'parth@gmail.com','8586','7891641238', 13000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7470,'Ankush Singh', 'singh@gmail.com','8587','7595641232', 1500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7280,'Anand Kumar', 'aman@gmail.com','8588','7695641233', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7190,'Aman Saini', 'sainiq@gmail.com','8589','7795641218', 5000)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + User_Contact.UserEntry.TABLE_NAME);
            onCreate(db);
        }

    }

    public Cursor readAllData() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" select * from " + TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData(int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" select * from " + TABLE_NAME + " where" + User_Contact.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + User_Contact.UserEntry.TABLE_NAME + " set " + User_Contact.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                User_Contact.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
        // Log.d("Update","Updated Amount");

    }
    public void updateAmount1(int accountNo,int amount){
            Log.d("TAG", "update Amount"+amount);
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("update " + User_Contact.UserEntry.TABLE_NAME + " set " + User_Contact.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                    User_Contact.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);

    }

}
