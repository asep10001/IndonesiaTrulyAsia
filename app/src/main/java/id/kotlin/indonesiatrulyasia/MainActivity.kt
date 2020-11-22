package id.kotlin.indonesiatrulyasia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardBatik = findViewById<CardView>(R.id.card_view)

        cardBatik.setOnClickListener{
            val intent = Intent(this, BatikActivity::class.java)
            startActivity(intent)
        }

        cardCovid19.setOnClickListener{
            val intent = Intent(this, CovidActivity::class.java )
            startActivity(intent)
        }

        card_regions.setOnClickListener{
            val intent = Intent(this, RegionsActivity::class.java )
            startActivity(intent)
        }
    }
}
