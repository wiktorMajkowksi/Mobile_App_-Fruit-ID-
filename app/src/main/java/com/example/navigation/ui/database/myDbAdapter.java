package com.example.navigation.ui.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class myDbAdapter {
    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    /*
           Inserts data into database.
           Takes 4 string arguments, those strings are then
           injected in the database in accordance to specified fields
     */
    public long insertData(String name, String pass, String re_pass, String email)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, pass);
        contentValues.put(myDbHelper.RE_PASSWORD, re_pass);
        contentValues.put(myDbHelper.EMAIL, email);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }
    /*
        Method for authorising login attempt.
        Extracts Email and Password of each entry and joins them into
        one string separated with " ",
        the string is then added to arraylist, it is done for whole database
     */
    public ArrayList getAuth(){
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.EMAIL, myDbHelper.MyPASSWORD};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        ArrayList buffer= new ArrayList();
        while (cursor.moveToNext())
        {
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.EMAIL));
            String password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            buffer.add(name + " " + password);
        }
        return buffer;
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "mylocalDatabase";                              // Database Name
        private static final String TABLE_NAME = "myTable";                                         // Table Name
        private static final int DATABASE_Version = 1;                                              // Database Version
        private static final String UID="_id";                                                      // Column I (Primary Key)
        private static final String NAME = "Name";                                                  // Column II
        private static final String MyPASSWORD= "Password";                                         // Column III
        private static final String RE_PASSWORD= "Re_password";                                     // Column IV
        private static final String EMAIL= "Email";                                                 // Column V
        //Creates table
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) ,"+ MyPASSWORD+" VARCHAR(225),"+RE_PASSWORD+" VARCHAR(225),"+ EMAIL+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;                 // Drops tables
        private Context context;

        /*
            extracts context of a given database
         */
        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        /*
          creates SQLiteDatabase
        */
        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}