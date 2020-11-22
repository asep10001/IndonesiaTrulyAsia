package id.kotlin.indonesiatrulyasia.services

import id.kotlin.indonesiatrulyasia.models.responses.MuseumResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface MuseumServices {
    @GET("api/index.php/CcariMuseum/searchGET?nama=museum")
    fun getDataMuseum(): Call<MuseumResponseServer>
}