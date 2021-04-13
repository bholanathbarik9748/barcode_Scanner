package com.example.barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView, imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView6);
        imageView1 = findViewById(R.id.imageView9);
        imageView2 = findViewById(R.id.imageView12);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prv();
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prv1();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prv2();
            }
        });
    }

    private void prv() {
        Intent intent = new Intent(this, privacy.class);
        startActivity(intent);
    }

    private void prv1() {
        Intent intent = new Intent(MainActivity.this, Termandcondition.class);
        startActivity(intent);
    }

    private void prv2() {
        Intent intent = new Intent(MainActivity.this, Company_Rule.class);
        startActivity(intent);
    }
}