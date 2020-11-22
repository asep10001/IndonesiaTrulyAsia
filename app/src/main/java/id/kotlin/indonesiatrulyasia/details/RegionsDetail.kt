package id.kotlin.indonesiatrulyasia.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.kotlin.indonesiatrulyasia.R
import kotlinx.android.synthetic.main.activity_regions_detail.*

class RegionsDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regions_detail)

        val nama_regions = intent.getStringExtra("nama")

        textNamaProvinsiRegions.text = nama_regions
    }
}
