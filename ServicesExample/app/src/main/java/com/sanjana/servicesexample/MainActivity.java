package com.sanjana.servicesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    int c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c == 0) {
                    Intent intent = new Intent(MainActivity.this, MyService.class);
                    startService(intent);
                    c++;
                    imageView.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                }
                else {
                    imageView.setImageResource(R.drawable.ic_baseline_stop_24);
                    Intent intent = new Intent(MainActivity.this, MyService.class);
                    stopService(intent);
                    c--;
                }
            }
        });
    }
}