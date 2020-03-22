package com.example.sqliteaplikasiprediksigizi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// if(inputTinggiBadan >25 && <30){
//   maka inputan masuk dalam kelompok (25-30);
// }

public class InputDataTestingActivity extends AppCompatActivity {

    EditText jenisKelamin, tinggiBadan, beratBadan, umur;
    TextView tampilJK, tampilTB, tampilBB, tampilUmur;
    Button btnProses;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_testing);

        jenisKelamin = findViewById(R.id.JK);
        tinggiBadan  = findViewById(R.id.tinggi_badan);
        beratBadan   = findViewById(R.id.berat_badan);
        umur         = findViewById(R.id.umur);

        tampilJK   = findViewById(R.id.tampil_jk);
        tampilTB   = findViewById(R.id.tampil_tb);
        tampilBB   = findViewById(R.id.tampil_bb);
        tampilUmur = findViewById(R.id.tampil_umur);

        btnProses    = findViewById(R.id.btn_proses);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kerjakan...

                // menyimpan inputan editteks kedalam variable
                String StringJenisKelamin  = jenisKelamin.getText().toString();
                String StringTinggiBadan   = tinggiBadan.getText().toString();
                String StringBeratBadan    = beratBadan.getText().toString();
                String StringUmur          = umur.getText().toString();

                // meng-set teksview dengan isi yg telah diinputkan
                tampilJK.setText(StringJenisKelamin);
                tampilTB.setText(StringTinggiBadan);
                tampilBB.setText(StringBeratBadan);
                tampilUmur.setText(StringUmur);

            }
        });

    }

}

















