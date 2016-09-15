package com.sapeu.android.criminalintent.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sapeu.android.criminalintent.database.CrimeDbSchema.CrimeTable;

/**
 * Created by Sapeu on 2016/9/13.
 */
public class CrimeBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATEBASE_NAME = "crimeBase.db";

    public CrimeBaseHelper(Context context){
        super(context,DATEBASE_NAME,null,VERSION);
    }

    /*public CrimeBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + CrimeTable.NAME + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                CrimeTable.Cols.UUID + "," +
                CrimeTable.Cols.DATE + "," +
                CrimeTable.Cols.SOLVED + "," +
                CrimeTable.Cols.TITLE + "," +
                CrimeTable.Cols.SUSPECT+ ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
