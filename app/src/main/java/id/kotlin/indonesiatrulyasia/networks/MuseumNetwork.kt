package id.kotlin.indonesiatrulyasia.networks

import id.kotlin.indonesiatrulyasia.services.MuseumServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MuseumNetwork {
    companion object {

        fun getRetrofit(): MuseumServices {

            val retrofit = Retrofit.Builder()
                .baseUrl("http://jendela.data.kemdikbud.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(MuseumServices::class.java)
        }
    }
}