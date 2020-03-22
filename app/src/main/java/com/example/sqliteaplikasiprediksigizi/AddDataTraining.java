package com.example.sqliteaplikasiprediksigizi;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddDataTraining extends Activity implements OnClickListener {

    EditText edtNama, edtJenisKelamin, edtTinggiBadan, edtBeratBadan, edtUmur, edtBB_umur, edtTB_umur, edtBB_TB;
    TextView tampilJK, tampilTB, tampilBB, tampilUmur;
    Button btnSimpan;

    //inisialisasi kontroller/Data Source
    private DBDataSource dataSource;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data_training);


        // Variabel dibawah oini untuk menyimpan value Inputan user pada EditTeks
        edtNama = findViewById(R.id.nama);
        edtJenisKelamin = findViewById(R.id.JK);
        edtTinggiBadan = findViewById(R.id.tinggi_badan);
        edtBeratBadan = findViewById(R.id.berat_badan);
        edtUmur = findViewById(R.id.umur);

        edtBB_umur = findViewById(R.id.BB_umur);
        edtTB_umur = findViewById(R.id.TB_umur);
        edtBB_TB   = findViewById(R.id.BB_TB);

        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(this);

        // instanstiasi kelas DBDataSource
        dataSource = new DBDataSource(this);

        //membuat sambungan baru ke database
        dataSource.open();

    }

    //KETIKA Tombol Submit Diklik
    @Override
    public void onClick(View v) {
        // Inisialisasi data balita
        String nama = null;
        String jenisKelamin = null;
        String tinggiBadan = null;
        String beratBadan = null;
        String umur = null;

        String BB_umur = null;
        String TB_umur = null;
        String BB_TB = null;

        @SuppressWarnings("unused")

        //inisialisasi data balita baru (masih kosong)
                ModelData dataBalita = null;
        if (edtNama.getText() != null && edtJenisKelamin.getText() != null
                && edtTinggiBadan.getText() != null && edtBeratBadan.getText() != null
                && edtUmur.getText() != null && edtBB_umur.getText() != null && edtTB_umur.getText() != null && edtBB_TB.getText() != null) {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data balita*/
            nama = edtNama.getText().toString();
            jenisKelamin = edtJenisKelamin.getText().toString();
            tinggiBadan = edtTinggiBadan.getText().toString();
            beratBadan = edtBeratBadan.getText().toString();     // PEMANGGILAN METHOD TO STRING() yg berada di kelas MODEL DATA ///
            umur = edtUmur.getText().toString();

            BB_umur = edtBB_umur.getText().toString();
            TB_umur = edtTB_umur.getText().toString();
            BB_TB   = edtBB_TB.getText().toString();

            //  }

            switch (v.getId()) {
                case R.id.btn_simpan:
                    // insert data barang baru
                    dataBalita = dataSource.createBarang(nama, jenisKelamin, tinggiBadan, beratBadan, umur, BB_umur, TB_umur, BB_TB);

                    //konfirmasi kesuksesan
                    Toast.makeText(this, "telah masuk data balita :\n" +
                            "nama          : " + dataBalita.getNama_balita() +
                            "\njenis kelamin : " + dataBalita.getJenis_kelamin() +
                            "\ntinggi badan  : " + dataBalita.getTinggi_badan() +
                            "\nberat badan   : " + dataBalita.getBerat_badan() +
                            "\numur          : " + dataBalita.getUmur()  +
                            "\nstatus BB/U   : " + dataBalita.getBB_umur() +
                            "\nstatus TB/U   : " + dataBalita.getTB_umur() +
                            "\nstatus BB/TB  : " + dataBalita.getBB_TB(), Toast.LENGTH_LONG).show();
                    break;
            }

        }

//        btnSimpan.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // insert data barang baru
//                dataBalita = dataSource.createBarang(nama, jeniskelamin, tinggiBadan, beratBadan, umur);
//
//                //konfirmasi kesuksesan
//                Toast.makeText(this, "masuk Barang\n" +
//                        " nama" + dataBalita.getNama_balita() +
//                        " jenis kelamin" + dataBalita.getJenis_kelamin() +
//                        " tinggi badan" + dataBalita.getTinggi_badan() +
//                        " berat badan" + dataBalita.getBerat_badan() +
//                        " umur" + dataBalita.getUmur(), Toast.LENGTH_LONG).show();
//            }
//        });


    }
}
