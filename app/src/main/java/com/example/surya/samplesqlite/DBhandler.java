package com.example.surya.samplesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by surya on 12/11/16.
 */
public class DBhandler {

    private SQLiteDatabase database;
    private SQLiteOpenHelper dbHelper;

    public DBhandler(Context context){

        dbHelper=new DatabaseHandler(context);
    }

    public void createStudent(Student student){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constants.STUDENT_FIRST_NAME,student.getFirstName());
        values.put(Constants.STUDENT_LAST_NAME,student.getLAstName());
        values.put(Constants.STUDENT_AGE,student.getAge());
        values.put(Constants.STUDENT_EMAIL,student.getEmail());
        values.put(Constants.STUDENT_CITY,student.getCity());

        sqLiteDatabase.insert(Constants.TABLE_NAME,null,values);
        sqLiteDatabase.close();
    }

    public ArrayList<Student> showAllStudents(){
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        ArrayList<Student> arrayStudent=new ArrayList<Student>();
        String query="SELECT "
                        + Constants.STUDENT_ID +", "
                        + Constants.STUDENT_FIRST_NAME +", "
                        + Constants.STUDENT_LAST_NAME +", "
                        + Constants.STUDENT_AGE + ", "
                        + Constants.STUDENT_EMAIL + ", "
                        + Constants.STUDENT_CITY + " FROM "
                        + Constants.TABLE_NAME ;

            Cursor cursor=sqLiteDatabase.rawQuery(query,null);
            if(cursor.moveToFirst()){
                do{
                    Student student=new Student();
                    student.setStudentID(Integer.parseInt(cursor.getString(0)));
                    student.setFirstName(cursor.getString(1));
                    student.setLAstName(cursor.getString(2));
                    student.setAge(Integer.parseInt(cursor.getString(3)));
                    student.setEmail(cursor.getString(4));
                    student.setCity(cursor.getString(5));
                    arrayStudent.add(student);
                }while(cursor.moveToNext());
            }
                sqLiteDatabase.close();
                return arrayStudent;
    }

    public int updatestudent(Student student){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constants.STUDENT_FIRST_NAME,student.getFirstName());
        values.put(Constants.STUDENT_LAST_NAME,student.getLAstName());
        values.put(Constants.STUDENT_AGE,student.getAge());
        values.put(Constants.STUDENT_EMAIL,student.getEmail());
        values.put(Constants.STUDENT_CITY,student.getCity());

        int value= sqLiteDatabase.update(Constants.TABLE_NAME,values,Constants.STUDENT_ID+"= ?",new String[] {String.valueOf(student.getStudentID())});
        sqLiteDatabase.close();
        return value;
    }

    public void deleteStudent(Student student){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        sqLiteDatabase.delete(Constants.TABLE_NAME,Constants.STUDENT_ID + "= ?",new String[]{String.valueOf(student.getStudentID())});
        sqLiteDatabase.close();
    }

}
