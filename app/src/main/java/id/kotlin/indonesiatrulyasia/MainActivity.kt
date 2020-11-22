package id.kotlin.indonesiatrulyasia

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import id.kotlin.indonesiatrulyasia.adpaters.MainSlideAdapter
import id.kotlin.indonesiatrulyasia.models.data.MainSlide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainSlideAdapter = MainSlideAdapter(
        listOf(
            MainSlide(
                "Explore True Exotic Indonesian Batik",
                R.drawable.batik,

            ),
            MainSlide(
                "Be Informed By The Current Covid19 Update",
                R.drawable.covid19
            ),
            MainSlide(
                "Know More About The Provinces",
                R.drawable.petaindonesia
            ),
            MainSlide(
                "Acknowledge and Learn from the Past",
                R.drawable.museum
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainSliderView.adapter = mainSlideAdapter
        setupIndicators()
        setCUrrentIndicator(2)
        mainSliderView.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCUrrentIndicator(position)
            }
        })

        val cardBatik = findViewById<CardView>(R.id.card_view)

        cardBatik.setOnClickListener {
            val intent = Intent(this, BatikActivity::class.java)
            startActivity(intent)
        }

        cardCovid19.setOnClickListener {
            val intent = Intent(this, CovidActivity::class.java)
            startActivity(intent)
        }

        card_regions.setOnClickListener {
            val intent = Intent(this, RegionsActivity::class.java)
            startActivity(intent)
        }
        card_museum.setOnClickListener{
            val intent = Intent(this, MuseumActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(mainSlideAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(20,0,20,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply{
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicatorConatiner.addView(indicators[i])
        }
    }

    private fun setCUrrentIndicator(index: Int){
        val childCount = indicatorConatiner.childCount
        for(i in 0 until childCount){
            val imageView = indicatorConatiner[i] as ImageView
            if(i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            } else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }
        }
    }
}
