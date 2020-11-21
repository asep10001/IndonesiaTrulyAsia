package id.kotlin.indonesiatrulyasia.networks

import id.kotlin.indonesiatrulyasia.services.CovidServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CovidNetwork {
    companion object {

        fun getRetrofit(): CovidServices {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://data.covid19.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(CovidServices::class.java)
        }
    }
}