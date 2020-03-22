package com.example.sqliteaplikasiprediksigizi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class InputDataTrainingActivity extends AppCompatActivity {

    Button btnTambahData;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_training);

        btnTambahData = findViewById(R.id.btn_tambah_data_training);

        btnTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InputDataTrainingActivity.this, AddDataTraining.class);
                startActivity(i);
            }
        });

/////// DISNI KITA AKAN MENAMPILKAN DATA YG DITAMBAHKAN DENGAN (AddDataTraining.java) KEDALAM BENTUK TABEL //////////
    }

}
