package com.example.sqliteaplikasiprediksigizi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //deklarasi
    Button btnTesting;
    Button btnTraining;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTesting   = findViewById(R.id.btn_testing);
        btnTraining = findViewById(R.id.btn_training);

        btnTesting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahLayoutTesting = new Intent(MainActivity.this, InputDataTestingActivity.class);
                startActivity(pindahLayoutTesting);
            }
        });

        btnTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahLayoutTraining = new Intent(MainActivity.this, InputDataTrainingActivity.class);
                startActivity(pindahLayoutTraining);
            }
        });

    }
}

