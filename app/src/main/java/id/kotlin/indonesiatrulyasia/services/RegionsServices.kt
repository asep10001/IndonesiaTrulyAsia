package id.kotlin.indonesiatrulyasia.services

import id.kotlin.indonesiatrulyasia.models.responses.RegionsResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface RegionsServices {
    @GET("api/daerahindonesia/provinsi")
    fun getDataRegions(): Call<RegionsResponseServer>
}