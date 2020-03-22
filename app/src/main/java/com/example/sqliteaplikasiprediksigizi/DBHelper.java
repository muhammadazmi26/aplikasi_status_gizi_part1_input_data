package com.example.sqliteaplikasiprediksigizi;

//deklarasi import package
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{
    /** deklarasi konstanta-konstanta yang digunakan pada database, seperti nama tabel,
     nama-nama kolom, nama database, dan versi dari database **/
    public static final String TABLE_NAME = "data_balita";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "nama_balita";
    public static final String COLUMN_JENIS_KELAMIN = "jenis_kelamin";
    public static final String COLUMN_TINGGI_BADAN = "tinggi_badan";
    public static final String COLUMN_BERAT_BADAN = "berat_badan";
    public static final String COLUMN_UMUR = "umur";
    public static final String COLUMN_BB_UMUR = "BB_umur";
    public static final String COLUMN_TB_UMUR = "TB_umur";
    public static final String COLUMN_BB_TB = "BB_TB";

    private static final String db_name ="balita.db";
    private static final int db_version=1;

    // Perintah SQL untuk membuat tabel database baru
    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_JENIS_KELAMIN+ " varchar(50) not null, "
            + COLUMN_TINGGI_BADAN+ " varchar(50) not null, "
            + COLUMN_BERAT_BADAN+ " varchar(50) not null, "
            + COLUMN_UMUR+ " varchar(50) not null, "
            + COLUMN_BB_UMUR+ " varchar(50) not null, "
            + COLUMN_TB_UMUR+ " varchar(50) not null, "
            + COLUMN_BB_TB+ " varchar(50) not null);";

    public DBHelper(Context context) {
        super(context, db_name, null, db_version);
        // Auto generated
    }

    //mengeksekusi perintah SQL di atas untuk membuat tabel database baru
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }

    // dijalankan apabila ingin mengupgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),"Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

}