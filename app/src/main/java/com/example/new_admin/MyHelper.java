package com.example.new_admin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(@Nullable Context context) {
        super(context, "DOCTOR_Reg", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Doctor (Name varchar(40),Email String,Mobile String ,Password varchar(20),Eduaction Varchar(40),Department Varchar(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);

    }

    void insertRecords(String Name, String Email, String Mobile, String Password, String Education,String Department)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("Name",Name);
        values.put("Email",Email);
        values.put("Mobile",Mobile);
        values.put("Password",Password);
        values.put("Education",Education);
        values.put("Department",Department);
        db.insert("Doctor ", null, values);
        db.close();
    }

    public Cursor getRecords()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("Select *from Doctor ",null);
        return c;
    }


}




















































 /*
    public String getSinlgeEntry(String Name)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("Doctor", null, " Name=?", new String[]{Name}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String Email= cursor.getString(cursor.getColumnIndex("Email"));
        String Mobile= cursor.getString(cursor.getColumnIndex("Mobile"));
        String password= cursor.getString(cursor.getColumnIndex("Password"));
        String Education= cursor.getString(cursor.getColumnIndex("Education"));
        String Department= cursor.getString(cursor.getColumnIndex("Department"));
        cursor.close();
        return password;
       // return Email;

    }

   */
