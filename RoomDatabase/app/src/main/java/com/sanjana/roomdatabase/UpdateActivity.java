package com.sanjana.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText updateName, updateRollNO;
    StudentEntity studentEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        updateName = findViewById(R.id.update_name);
        updateRollNO = findViewById(R.id.update_rollno);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String rollno = intent.getStringExtra("roll");
        updateName.setText(name);
        updateRollNO.setText(rollno);
        updateRollNO.setKeyListener(null);
    }

    public void updateData(View view) {
        String updatedName = updateName.getText().toString();
        String updatedRollNo = updateRollNO.getText().toString();
        studentEntity = new StudentEntity();
        studentEntity.setRollNumber(updatedRollNo);
        studentEntity.setName(updatedName);
        //MainActivity.database.studentDAO().updateData(studentEntity);
        //live db
        MainActivity.viewModel.update(studentEntity);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}