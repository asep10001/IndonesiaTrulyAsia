package id.kotlin.indonesiatrulyasia.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.kotlin.indonesiatrulyasia.R
import kotlinx.android.synthetic.main.activity_batik_detail.*

class BatikDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batik_detail)

        val nama_batik = intent.getStringExtra("nama_batik")
        val daerah_batik = intent.getStringExtra("daerah_batik")
        val makna_batik = intent.getStringExtra("makna_batik")
        val harga_rendah = intent.getStringExtra("harga_rendah")
        val harga_tinggi = intent.getStringExtra("harga_tinggi")
        val link_batik = intent.getStringExtra("link_batik")

        textNamaBatikDetail.text = nama_batik
        textHargaTinggi.text = "Harga tertinggi : \n" + harga_tinggi
        textHargarendah.text = "Harga terendah : \n" + harga_rendah
        textMakna.text = makna_batik

        Glide.with(this).load(link_batik).into(imageBatikDetail)


    }
}
