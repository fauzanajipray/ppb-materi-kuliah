package com.udinus.sqllite_11330;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="data_mhs.db";
    public static final String TABLE_NAME="table_mhs";
    public static final String COL_1="nim";
    public static final String COL_2="nama_mhs";
    public static final int DATABASE_VERSION=1;

    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL("create table "+ TABLE_NAME + "("+ COL_1 +" text,"+ COL_2 +" text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nim, String nama_mhs){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_1, nim);
            contentValues.put(COL_2, nama_mhs);
            long result = db.insert(TABLE_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // SHOW DATA
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from table_mhs", null);
        return res;
    }

    // UPDATE DATA
    public boolean updateData(String nim, String nama_mhs){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put (COL_1, nim);
            contentValues.put (COL_2, nama_mhs);

            db.update(TABLE_NAME, contentValues, "nim = ?", new String[]{nim});
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public int deleteData (String nim){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "nim = ?", new String[]{nim});
    }
}
