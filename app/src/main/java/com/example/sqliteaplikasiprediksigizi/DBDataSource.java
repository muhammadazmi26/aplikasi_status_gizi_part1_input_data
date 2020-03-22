package com.example.sqliteaplikasiprediksigizi;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBDataSource {

    //inisialiasi SQLite Database
    private SQLiteDatabase database;

    //inisialisasi kelas DBHelper
    private DBHelper dbHelper;

    //ambil semua nama kolom
    private String[] allColumns = { DBHelper.COLUMN_ID,
            DBHelper.COLUMN_NAME, DBHelper.COLUMN_JENIS_KELAMIN, DBHelper.COLUMN_TINGGI_BADAN, DBHelper.COLUMN_BERAT_BADAN, DBHelper.COLUMN_UMUR, DBHelper.COLUMN_BB_UMUR, DBHelper.COLUMN_TB_UMUR, DBHelper.COLUMN_BB_TB};

    //DBHelper diinstantiasi pada constructor
    public DBDataSource(Context context)
    {
        dbHelper = new DBHelper(context);
    }

    //membuka/membuat sambungan baru ke database
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    //menutup sambungan ke database
    public void close() {
        dbHelper.close();
    }

    //method untuk create/insert barang ke database
    public ModelData createBarang(String nama, String jenisKelamin, String tinggiBadan, String beratBadan, String umur, String BB_umur, String TB_umur, String BB_TB)  {

        // membuat sebuah ContentValues, yang berfungsi
        // untuk memasangkan data dengan nama-nama
        // kolom pada database
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, nama);
        values.put(DBHelper.COLUMN_JENIS_KELAMIN, jenisKelamin);
        values.put(DBHelper.COLUMN_TINGGI_BADAN, tinggiBadan);
        values.put(DBHelper.COLUMN_BERAT_BADAN, beratBadan);
        values.put(DBHelper.COLUMN_UMUR, umur);
        values.put(DBHelper.COLUMN_BB_UMUR, BB_umur);
        values.put(DBHelper.COLUMN_TB_UMUR, TB_umur);
        values.put(DBHelper.COLUMN_BB_TB, BB_TB);

        // mengeksekusi perintah SQL insert data
        // yang akan mengembalikan sebuah insert ID
        long insertId = database.insert(DBHelper.TABLE_NAME, null,
                values);

        // setelah data dimasukkan, memanggil
        // perintah SQL Select menggunakan Cursor untuk
        // melihat apakah data tadi benar2 sudah masuk
        // dengan menyesuaikan ID = insertID
        Cursor cursor = database.query(DBHelper.TABLE_NAME, allColumns, DBHelper.COLUMN_ID + " = " + insertId, null, null, null, null);

        // pindah ke data paling pertama
        cursor.moveToFirst();

        // mengubah objek pada kursor pertama tadi
        // ke dalam objek newData
        //  Barang newBarang = cursorToBarang(cursor);
        ModelData newData = cursorToBalita(cursor);

        // close cursor
        cursor.close();

        // mengembalikan data balita baru
        return newData;
    }

    private ModelData cursorToBalita(Cursor cursor)
    {
        // buat objek barang baru
        ModelData dataBalita = new ModelData();
        // debug LOGCAT
        Log.v("info", "The getLONG "+cursor.getLong(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2)
                +","+cursor.getString(3) +","+cursor.getString(4) +","+cursor.getString(5)
                +","+cursor.getString(6)  +","+cursor.getString(7)  +","+cursor.getString(8));

        /* Set atribut pada objek barang dengan
         * data kursor yang diambil dari database*/
        dataBalita.setId(cursor.getLong(0));
        dataBalita.setNama_balita(cursor.getString(1));
        dataBalita.setJenis_kelamin(cursor.getString(2));
        dataBalita.setTinggi_badan(cursor.getString(3));
        dataBalita.setBerat_badan(cursor.getString(4));
        dataBalita.setUmur(cursor.getString(5));
        dataBalita.setBB_umur(cursor.getString(6));
        dataBalita.setTB_umur(cursor.getString(7));
        dataBalita.setBB_TB(cursor.getString(8));

        //kembalikan sebagai objek barang
        return dataBalita;
    }
}















//class DBDataSource {
//    public void open() {
//    }
//
//    public ModelData createBarang(String nama, String jeniskelamin, String tinggiBadan, String beratBadan, String umur) {
//    }
//}
