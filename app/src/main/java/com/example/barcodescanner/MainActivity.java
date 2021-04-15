package com.example.barcodescanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView, imageView1, imageView2;
    private Button button, button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Id initialization
        imageView = findViewById(R.id.imageView6);
        imageView1 = findViewById(R.id.imageView9);
        imageView2 = findViewById(R.id.imageView12);
        imageView2 = findViewById(R.id.imageView12);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);

//        OnClickListener List

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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prv3();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prv4();
            }
        });
    }

    //    method OnClickListener
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

    private void prv3() {
        IntentIntegrator intent = new IntentIntegrator(MainActivity.this);
        intent.setCaptureActivity(clickAct.class);
        intent.setOrientationLocked(false);
        intent.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intent.setPrompt("Scanning Code");
        intent.initiateScan();
    }

    private void prv4() {
        Intent intent = new Intent(MainActivity.this, epPage.class);
        startActivity(intent);
    }

    //    Scanner Button Code and Messager
    protected void onActivityResult(int req_code, int res_code, Intent data) {
        IntentResult res = IntentIntegrator.parseActivityResult(req_code, res_code, data);
        if (res != null) {
            if (res.getContents() != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(res.getContents());
                builder.setTitle("Scanner result : ");
                builder.setPositiveButton("Scan Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        prv3();
                    }
                }).setNegativeButton("Finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                Toast.makeText(this, "No Result", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(req_code, res_code, data);
        }
    }
}