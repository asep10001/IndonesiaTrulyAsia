package id.kotlin.indonesiatrulyasia.services

import id.kotlin.indonesiatrulyasia.models.responses.MuseumResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface MuseumServices {
    @GET("api?action=findAll")
    fun getDataMuseum(): Call<MuseumResponseServer>
}