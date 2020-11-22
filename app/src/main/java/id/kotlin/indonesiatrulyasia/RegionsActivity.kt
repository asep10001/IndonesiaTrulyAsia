package id.kotlin.indonesiatrulyasia

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import id.kotlin.indonesiatrulyasia.adpaters.RegionsAdapter
import id.kotlin.indonesiatrulyasia.models.data.Regions
import id.kotlin.indonesiatrulyasia.models.responses.RegionsResponseServer
import id.kotlin.indonesiatrulyasia.networks.RegionsNetwork
import kotlinx.android.synthetic.main.activity_covid.progress
import kotlinx.android.synthetic.main.activity_regions.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regions)
        title ="Indonesia Truly Regions"

        if (isConnect()) {

            RegionsNetwork.getRetrofit().getDataRegions()
                .enqueue(object : Callback<RegionsResponseServer> {
                    override fun onResponse(
                        call: Call<RegionsResponseServer>,
                        response: Response<RegionsResponseServer>
                    ) {
                        Log.d("Response server", response.message())

                        if (response.isSuccessful) {

                            progress.visibility = View.GONE
                            val data = response.body()?.provinsi
                            Toast.makeText(this@RegionsActivity,data?.get(0)?.nama, Toast.LENGTH_SHORT).show()

                            showData(data)
                        }
                    }

                    override fun onFailure(call: Call<RegionsResponseServer>, t: Throwable) {
                        Toast.makeText(this@RegionsActivity, t.message, Toast.LENGTH_LONG).show()
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

    private fun showData(data: ArrayList<Regions>?) {
        listRegions.adapter =   RegionsAdapter(data)
    }
}
