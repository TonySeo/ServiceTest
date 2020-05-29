package com.example.servicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Provider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MainActivity-Service 시작버튼 클릭", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                startService(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MainActivity-Service 종료버튼 클릭", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                stopService(intent);
            }
        });
    }
}
