package id.kotlin.indonesiatrulyasia.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.kotlin.indonesiatrulyasia.R
import kotlinx.android.synthetic.main.activity_covid_detail.*
import kotlinx.android.synthetic.main.fragment_covid.*

class CovidDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_detail)

        val nama_provinsi = intent.getStringExtra("key")
        val jumlah_kasus = intent.getStringExtra("jumlah_kasus")
        val jumlah_dirawat = intent.getStringExtra("jumlah_dirawat")
        val jumlah_meninggal = intent.getStringExtra("jumlah_meninggal")
        val jumlah_sembuh = intent.getStringExtra("jumlah_sembuh")

        textNamaProvinsiCovid.text = nama_provinsi
        textJumlahKasusCovid.text = jumlah_kasus
        textJumlahDirawat.text = "Jumlah Dirawat : " +jumlah_dirawat
        textJumlahMeninggalCovid.text = "Jumlah Meninggal : " + jumlah_meninggal
        textJumlahSembuhCovid.text = "Jumlah Sembuh : " + jumlah_sembuh
        textJumlahKasus.text = "Jumlah Kasus : " + jumlah_kasus

    }
}