package com.sanjana.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText studentName, studentRollNo;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    static StudentDatabase database;
    StudentEntity studentEntity;
    List<StudentEntity> entityList;
    static ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentName = findViewById(R.id.student_name);
        studentRollNo = findViewById(R.id.student_rollno);
        recyclerView = findViewById(R.id.rec);
        database = Room.databaseBuilder(this, StudentDatabase.class, "sanjana").allowMainThreadQueries().build();
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.liveData().observe(this, new Observer<List<StudentEntity>>() {
            @Override
            public void onChanged(List<StudentEntity> studentEntities) {
                myAdapter = new MyAdapter(MainActivity.this, studentEntities);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(myAdapter);
            }
        });
    }

    public void saveData(View view) {
        String name = studentName.getText().toString();
        String rollNo = studentRollNo.getText().toString();
        studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setRollNumber(rollNo);
        database.studentDAO().insertData(studentEntity);
        viewModel.insert(studentEntity);
        Toast.makeText(this, "Inserted Succesfully", Toast.LENGTH_SHORT).show();
    }

    /*public void retrieveData(View view) {
        entityList = database.studentDAO().retrieveData();
        myAdapter = new MyAdapter(this, entityList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }*/
}