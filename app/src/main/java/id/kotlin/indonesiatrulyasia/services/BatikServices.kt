package id.kotlin.indonesiatrulyasia.services

import id.kotlin.indonesiatrulyasia.models.responses.BatikResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface BatikServices {
    @GET("index.php/batik/all")
    fun getDataBatik(): Call<BatikResponseServer>
}