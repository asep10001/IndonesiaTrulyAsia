package id.kotlin.indonesiatrulyasia.networks

import id.kotlin.indonesiatrulyasia.services.RegionsServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegionsNetwork {
    companion object {

        fun getRetrofit(): RegionsServices {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://dev.farizdotid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RegionsServices::class.java)
        }
    }
}