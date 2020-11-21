package id.kotlin.indonesiatrulyasia.networks

import id.kotlin.indonesiatrulyasia.services.BatikServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BatikNetwork {
    companion object {

        fun getRetrofit(): BatikServices {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://batikita.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(BatikServices::class.java)
        }
    }
}