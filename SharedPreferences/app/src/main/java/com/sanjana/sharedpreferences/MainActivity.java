package com.sanjana.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, email, password;
    Button register, login;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.et_username);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        preferences = getSharedPreferences("apssdc", MODE_PRIVATE);
    }

    public void register(View view) {
        String userName = username.getText().toString();
        String Password = password.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        if(userName.equals("")) {
            Toast.makeText(this, "Enter UserName", Toast.LENGTH_SHORT).show();
        }
        else if(Password.equals("")) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else {
            editor.putString("name", userName);
            editor.putString("password", Password);
            editor.apply();
            Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    public void login(View view) {
        Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent1);
    }
}