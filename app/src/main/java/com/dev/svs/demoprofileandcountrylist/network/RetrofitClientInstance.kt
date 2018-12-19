package com.dev.svs.demoprofileandcountrylist.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClientInstance {

    companion object {
        private var retrofit: Retrofit? = null
        private const val BASE_URL = "https://restcountries.eu/rest/v1/"

        fun getRetrofitInstance(): Retrofit {
            if (retrofit == null) {

                val logging = HttpLoggingInterceptor()
                // set your desired log level
                logging.level = HttpLoggingInterceptor.Level.BODY

                val httpClient = OkHttpClient.Builder()

                // add your other interceptors …
                // add logging as last interceptor
                httpClient.addInterceptor(logging)  // <-- this is the important lin

                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
            }
            return retrofit!!
        }
    }
}