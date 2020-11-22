package id.kotlin.indonesiatrulyasia

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.indonesiatrulyasia.adpaters.MuseumAdapter
import id.kotlin.indonesiatrulyasia.models.data.Museum
import id.kotlin.indonesiatrulyasia.models.responses.MuseumResponseServer
import id.kotlin.indonesiatrulyasia.networks.MuseumNetwork
import kotlinx.android.synthetic.main.activity_covid.progress
import kotlinx.android.synthetic.main.activity_museum.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class MuseumActivity : AppCompatActivity() {
    lateinit var searchView: SearchView
    var itemList: MutableList<Museum>? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)
        title = "Indonesia Truly Museum"

        searchView = findViewById(R.id.searchView)

        if (isConnect()) {

            showData()

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {

                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    filterList(newText)

                    return false
                }
            })

        } else {

            progress.visibility = View.GONE

            Toast.makeText(this, "device tidak connect dengan intenet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun filterList(searchTern: String) {
        var tempList: MutableList<Museum>? = ArrayList()
        if (searchTern!!.isNotEmpty()) {
            val search = searchTern?.toLowerCase(Locale.getDefault())
            for (it in itemList!!) {
                if (it.nama.toString().toLowerCase(Locale.getDefault()).contains(search)) {
//                    Toast.makeText(this@MuseumActivity, it.nama, Toast.LENGTH_SHORT).show()
                    tempList?.add(it)
                }
            }
        } else {
            tempList = itemList
        }
        listMuseumData.adapter = MuseumAdapter(tempList)
    }

    private fun isConnect(): Boolean {

        val connect: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }


    private fun showData() {
        MuseumNetwork.getRetrofit().getDataMuseum()
            .enqueue(object : Callback<MuseumResponseServer> {
                override fun onResponse(
                    call: Call<MuseumResponseServer>,
                    response: Response<MuseumResponseServer>
                ) {
                    Log.d("Response server", response.message())

                    if (response.isSuccessful) {

                        progress.visibility = View.GONE
                        itemList = response.body()?.data
                        listMuseumData.adapter = MuseumAdapter(itemList)
                    }
                }

                override fun onFailure(call: Call<MuseumResponseServer>, t: Throwable) {
                    Toast.makeText(this@MuseumActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}
