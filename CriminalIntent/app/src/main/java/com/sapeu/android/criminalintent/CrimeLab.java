package com.sapeu.android.criminalintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import com.sapeu.android.criminalintent.database.CrimeBaseHelper;
import com.sapeu.android.criminalintent.database.CrimeDbSchema;
import com.sapeu.android.criminalintent.database.CrimeDbSchema.CrimeTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sapeu on 2016/9/10.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;
//    private List<Crime> mCrimes;
    private Context mContext;
    private SQLiteDatabase mSQLiteDatabase;

    public static CrimeLab get(Context context){
        if (null == sCrimeLab){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mContext = context.getApplicationContext();
        mSQLiteDatabase = new CrimeBaseHelper(context).getWritableDatabase();
//        mCrimes = new ArrayList<Crime>();
        /*for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.add(crime);
        }*/
    }

    public List<Crime> getCrimes(){
//        return mCrimes;
        List<Crime> crimes = new ArrayList<Crime>();
        CrimeCursorWrapper cursor = queryCrimes(null,null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                crimes.add(cursor.getCrime());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return crimes;
    }

    public Crime getCrime(UUID id){
        /*for (Crime crime:mCrimes) {
            if (crime.getId().equals(id)){
                return crime;
            }
        }*/
//        return null;
        CrimeCursorWrapper cursor = queryCrimes(CrimeTable.Cols.UUID + " = ? ",new String[]{id.toString()});
        try {
            if (cursor.getCount() == 0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCrime();
        } finally {
            cursor.close();
        }
    }

    public void addCrime(Crime crime){
//        mCrimes.add(c);
        ContentValues values = getContentValues(crime);
        mSQLiteDatabase.insert(CrimeTable.NAME,null,values);
    }

    public void updateCrime(Crime crime){
        String uuidString = crime.getId().toString();
        ContentValues values = getContentValues(crime);
        mSQLiteDatabase.update(CrimeTable.NAME,values,CrimeTable.Cols.UUID + " = ?", new String[]{uuidString});
    }

    public void deleteCrime(Crime crime){
        String uuidString = crime.getId().toString();
        mSQLiteDatabase.delete(CrimeTable.NAME,CrimeTable.Cols.UUID + " = ?", new String[]{uuidString});
    }

    private static ContentValues getContentValues(Crime crime){
        ContentValues values = new ContentValues();
        values.put(CrimeTable.Cols.DATE,crime.getDate().getTime());
        values.put(CrimeTable.Cols.SOLVED,crime.isSolved() ? 1 : 0);
        values.put(CrimeTable.Cols.TITLE,crime.getTitle());
        values.put(CrimeTable.Cols.UUID,crime.getId().toString());
        return values;
    }

    private CrimeCursorWrapper queryCrimes(String whereClause, String[] whereArgs){
        Cursor cursor = mSQLiteDatabase.query(
                CrimeTable.NAME,
                null,// COLUMNS - null selects all columns
                whereClause,
                whereArgs,
                null, //GROUP BY
                null, //HAVING
                null // ORDER BY
        );

        return new CrimeCursorWrapper(cursor);
    }

}
