package id.kotlin.indonesiatrulyasia

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import id.kotlin.indonesiatrulyasia.adpaters.CovidAdapter
import id.kotlin.indonesiatrulyasia.models.data.Covid
import id.kotlin.indonesiatrulyasia.models.responses.BatikResponseServer
import id.kotlin.indonesiatrulyasia.models.responses.CovidResponseServer
import id.kotlin.indonesiatrulyasia.networks.BatikNetwork
import id.kotlin.indonesiatrulyasia.networks.CovidNetwork
import kotlinx.android.synthetic.main.activity_covid.*
import kotlinx.android.synthetic.main.activity_covid.progress
import kotlinx.android.synthetic.main.batik_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)

        if (isConnect()) {


            CovidNetwork.getRetrofit().getDataCovid()
                .enqueue(object : Callback<CovidResponseServer> {
                    override fun onResponse(
                        call: Call<CovidResponseServer>,
                        response: Response<CovidResponseServer>
                    ) {
                        Log.d("Response server", response.message())

                        if (response.isSuccessful) {

                            progress.visibility = View.GONE
                            val list_data = response.body()?.list_data

                            showData(list_data)
                        }
                    }

                    override fun onFailure(call: Call<CovidResponseServer>, t: Throwable) {
                        Toast.makeText(this@CovidActivity, t.message, Toast.LENGTH_LONG).show()
                    }

                })
        } else{

            progress.visibility = View.GONE

            Toast.makeText(this,"device tidak connect dengan intenet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isConnect() : Boolean{

        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        return  connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }

    private fun showData(data: ArrayList<Covid>?) {
        listCovidData.adapter =   CovidAdapter(data)
    }
}
