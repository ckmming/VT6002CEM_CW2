package com.example.boutiquemanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASENAME = "Boutique_Management_System";
    public static final int VERSION = 1;
    public static final String TABLE_NAME = "User_Details";
    public static final String ID_COL = "id";
    public static final String NAME_COL = "username";
    public static final String EMAIL_COL = "email";
    public static final String PHONE_COL = "phone";
    public static final String PASSWORD_COL = "Password";

    public DbHelper(Context context) {
        super(context, DATABASENAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PHONE_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";
        db.execSQL(query);

    }

    public void addUser(String userName, String email, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put(NAME_COL, userName);
        values.put(EMAIL_COL, email);
        values.put(PHONE_COL, phone);
        values.put(PASSWORD_COL, password);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public boolean loginByUsernameAndPassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from User_Details where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
//        Cursor cursor = db.query(TABLE_NAME, NAME_COL, PASSWORD_COL, username, password, null)
//        String getByUsernameAndPassword = "Select * from User_Details where username=? and password=?";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
