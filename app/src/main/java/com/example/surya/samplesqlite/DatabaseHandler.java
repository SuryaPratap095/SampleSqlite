package com.example.surya.samplesqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.surya.samplesqlite.Constants;

/**
 * Created by surya on 12/11/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {



    public DatabaseHandler(Context context) {
        super(context,Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       String query="CREATE TABLE "+Constants.TABLE_NAME+ "("
               + Constants.STUDENT_ID +" INTEGER PRIMARY KEY, "
               + Constants.STUDENT_FIRST_NAME + " TEXT, "
               + Constants.STUDENT_LAST_NAME + " TEXT, "
               + Constants.STUDENT_AGE + " INTEGER, "
               + Constants.STUDENT_EMAIL + " TEXT, "
               + Constants.STUDENT_CITY + " TEXT)";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP IF EXISTS TABLE "+ Constants.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
