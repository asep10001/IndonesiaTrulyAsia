package id.kotlin.indonesiatrulyasia

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.indonesiatrulyasia.adpaters.BatikAdapter
import id.kotlin.indonesiatrulyasia.models.data.Batik
import id.kotlin.indonesiatrulyasia.models.responses.BatikResponseServer
import id.kotlin.indonesiatrulyasia.networks.BatikNetwork
import kotlinx.android.synthetic.main.batik_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BatikActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.batik_layout)
        title ="Indonesia Truly Batik"

        if (isConnect()) {


            BatikNetwork.getRetrofit().getDataBatik()
                .enqueue(object : Callback<BatikResponseServer> {
                    override fun onResponse(
                        call: Call<BatikResponseServer>,
                        response: Response<BatikResponseServer>
                    ) {
                        Log.d("Response server", response.message())

                        if (response.isSuccessful) {

                            progress.visibility = View.GONE
                            val hasil = response.body()?.hasil

                            showData(hasil)
                        }
                    }

                    override fun onFailure(call: Call<BatikResponseServer>, t: Throwable) {
                        Toast.makeText(this@BatikActivity, t.message, Toast.LENGTH_LONG).show()
                    }

                })
        } else{

            progress.visibility = View.GONE

            Toast.makeText(this,"device tidak connect dengan intenet",Toast.LENGTH_SHORT).show()
        }

    }


    private fun isConnect() : Boolean{

        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        return  connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }
    private fun showData(data: ArrayList<Batik>?) {
        listBatik.adapter =   BatikAdapter(data)
    }


}