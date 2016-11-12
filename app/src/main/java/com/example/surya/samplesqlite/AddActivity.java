package com.example.surya.samplesqlite;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private DBhandler dBhandler;
    private Student student;
    private EditText edtLastName;
    private EditText edtAge;
    private EditText edtEmail;
    private EditText edtCity;
    private EditText edtFirstName;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dBhandler=new DBhandler(this);

        edtFirstName=(EditText)findViewById(R.id.editFirstName);
        edtLastName=(EditText)findViewById(R.id.editLastName);
       edtAge=(EditText)findViewById(R.id.editAge);
        edtEmail=(EditText)findViewById(R.id.editEmail);
        edtCity=(EditText)findViewById(R.id.editCity);




        Button btnSubmit=(Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student=new Student();
                student.setFirstName(edtFirstName.getText().toString());

                student.setLAstName(edtLastName.getText().toString());
                student.setEmail(edtEmail.getText().toString());
                student.setCity(edtCity.getText().toString());
                student.setAge(Integer.parseInt(edtAge.getText().toString()));
                Log.d("DAta actvity","Student Details [ "+student.getFirstName()+" "+student.getLAstName() + " "+student.getEmail());
                dBhandler.createStudent(student);
                finish();




            }
        });



    }
}
