package com.example.sqliteaplikasiprediksigizi;

    public class ModelData {

        private long id;
        private String nama_balita;
        private String jenis_kelamin;
        private String tinggi_badan;
        private String berat_badan;
        private String umur;

        private String BB_umur;
        private String TB_umur;
        private String BB_TB;

        public ModelData()
        {

        }

        /**
         * @return the id
         */
        public long getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(long id) {
            this.id = id;
        }

        /**
         * @return the nama_barang
         */
        public String getNama_balita() {
            return nama_balita;
        }

        /**
         * @param nama_balita the nama_barang to set
         */
        public void setNama_balita(String nama_balita) {
            this.nama_balita = nama_balita;
        }

        /**
         * @return the merk_barang
         */
        public String getJenis_kelamin() {
            return jenis_kelamin;
        }

        /**
         * @param jenis_kelamin the merk_barang to set
         */
        public void setJenis_kelamin(String jenis_kelamin) {
            this.jenis_kelamin = jenis_kelamin;
        }

        /**
         * @return the harga_barang
         */
        public String getTinggi_badan() {
            return tinggi_badan;
        }

        /**
         * @param tinggi_badan the harga_barang to set
         */
        public void setTinggi_badan(String tinggi_badan) {
            this.tinggi_badan = tinggi_badan;
        }


        /**
         * @return the harga_barang
         */
        public String getBerat_badan() {
            return berat_badan;
        }

        /**
         * @param berat_badan the harga_barang to set
         */
        public void setBerat_badan(String berat_badan) {
            this.berat_badan = berat_badan;
        }

        /**
         * @return the harga_barang
         */
        public String getUmur() {
            return umur;
        }

        /**
         * @param umur the harga_barang to set
         */
        public void setUmur(String umur) {
            this.umur = umur;
        }

        //   BB/U
        public String getBB_umur(){
            return BB_umur;
        }

        public void setBB_umur(String BB_umur){
            this.BB_umur = BB_umur;
        }

        //    TB/U
        public String getTB_umur(){
            return TB_umur;
        }

        public void setTB_umur(String TB_umur){
            this.TB_umur = TB_umur;
        }

        //     BB/TB
        public String getBB_TB(){
            return BB_TB;
        }

        public void setBB_TB(String BB_TB){
            this.BB_TB = BB_TB;
        }

        @Override
        public String toString()
        {
            return "ACER "+ nama_balita +" "+ jenis_kelamin + " "+ tinggi_badan + " " + berat_badan + " " + umur;
        }



//        @Override
//        public String toString()
//        {
//            return "Barang "+ nama_barang +" "+ merk_barang + " "+ harga_barang;
//        }
}
