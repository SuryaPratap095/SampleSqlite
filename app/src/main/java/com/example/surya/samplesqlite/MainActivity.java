package com.example.surya.samplesqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DBhandler dBhandler;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Student student=new Student("Pankaj ","Joshi",34,"suryaprat@.com","Delhi");
        // Student student=new Student(1,"Gifty", "Thomas",23,"gifty@gmail.com","Banglore");
        Student student1 = new Student(9, "Gifty", "Thomas", 23, "gifty@gmail.com", "Banglore");
        Student student2 = new Student(10, "Gifty", "Thomas", 23, "gifty@gmail.com", "Banglore");
        dBhandler = new DBhandler(this);
        //dBhandler.createStudent(student);
        //dBhandler.updatestudent(student);

        dBhandler.deleteStudent(student1);
        dBhandler.deleteStudent(student2);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        students = dBhandler.showAllStudents();
        for (Student s : students) {
            Toast.makeText(this, "ID " + s.getStudentID() + "Name: " + s.getFirstName()
                    + "LastName: " + s.getLAstName(), Toast.LENGTH_LONG).show();

            dBhandler = new DBhandler(this);
            //ArrayAdapter<Student> adapter=new ArrayAdapter<Student>()(this,R.layout.layout_listview_item,students);

            ListView listView = (ListView) findViewById(R.id.listviewStudent);
            StudentAdapter adapter = new StudentAdapter(this, students);
            listView.setAdapter(adapter);
        }
    }

}


