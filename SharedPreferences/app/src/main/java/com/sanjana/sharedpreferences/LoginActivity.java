package com.sanjana.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et_name, et_password;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_name = findViewById(R.id.et_login_username);
        et_password = findViewById(R.id.et_login_password);
        preferences = getSharedPreferences("apssdc", MODE_PRIVATE);

    }

    public void doneLogin(View view) {
        String user_given_name = et_name.getText().toString();
        String user_given_password = et_password.getText().toString();
        String reg_user = preferences.getString("name", "");
        String reg_password = preferences.getString("password", "");
        if(user_given_name.equals(reg_user) && user_given_password.equals(reg_password)) {
            Toast.makeText(this, "User Login Successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Sorry!! Once Check Your Credentials!!", Toast.LENGTH_SHORT).show();
        }
    }

}