package com.willyramad.chapterlimaretrofit.service

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL = "https://rent-cars-api.herokuapp.com/"

    val instance : ApiService by lazy {
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())

            .baseUrl(BASE_URL)
            .build()

        retrofit.create(ApiService::class.java)
    }
}