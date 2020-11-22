package id.kotlin.indonesiatrulyasia.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.indonesiatrulyasia.R
import kotlinx.android.synthetic.main.activity_museum_detail.*

class MuseumDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_detail)

        var museum_id = intent.getStringExtra("museum_id")
        var kode_pengelolaan = intent.getStringExtra("kode_pengelolaan")
        var nama = intent.getStringExtra("nama")
        var sdm = intent.getStringExtra("sdm")
        var alamat_jalan = intent.getStringExtra("alamat_jalan")
        var desa_kelurahan = intent.getStringExtra("desa_kelurahan")
        var kecamatan = intent.getStringExtra("kecamatan")
        var kabupaten_kota = intent.getStringExtra("kabupaten_kota")
        var propinsi = intent.getStringExtra("propinsi")
        var lintang = intent.getStringExtra("lintang")
        var bujur = intent.getStringExtra("bujur")
        var koleksi = intent.getStringExtra("koleksi")
        var sumber_dana = intent.getStringExtra("sumber_dana")
        var pengelola = intent.getStringExtra("pengelola")
        var tipe = intent.getStringExtra("tipe")
        var standar = intent.getStringExtra("standar")
        var tahun_berdiri = intent.getStringExtra("tahun_berdiri")
        var bangunan = intent.getStringExtra("bangunan")
        var luas_tanah = intent.getStringExtra("luas_tanah")
        var status_kepemilikan = intent.getStringExtra("status_kepemilikan")

        textNamaMuseumDetail.text = nama
        var deskripsi: String =
            "Museum dengan Id $museum_id ini dikelola oleh $pengelola dan dimiliki oleh $status_kepemilikan dengan id pengelolan $kode_pengelolaan. Museum ini memiliki sumber dana dari $sumber_dana dengan tipe pengelolaan $tipe. " +
                    "Museum ini berlokasi di lintang $lintang dan bujur $bujur. Memiliki koleksi $koleksi, bangunannya $bangunan yang didirikan pada tahun $tahun_berdiri dan memiliki luas  ${luas_tanah}km persegi." +
                    "Mempekerjakan orang sebanyak $sdm, museum ini memiliki standar $standar."
        textDescriptionMuseumDetail.text = deskripsi
        textAlamatMuseumDetail.text = "$alamat_jalan, \n $desa_kelurahan, $kecamatan \n $kabupaten_kota \n $propinsi"
    }
}
