package id.kotlin.indonesiatrulyasia.services

import id.kotlin.indonesiatrulyasia.models.responses.CovidResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface CovidServices {

    @GET("public/api/prov.json")
    fun getDataCovid(): Call<CovidResponseServer>
}