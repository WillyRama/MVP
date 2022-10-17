package com.willyramad.chapterlimaretrofit.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUser {
    const val BASE_URL = "https://6254434289f28cf72b5aed04.mockapi.io/user"
    val instance : ApiFullUser by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())

            .baseUrl(BASE_URL)
            .build()

        retrofit.create(ApiFullUser::class.java)
    }
}