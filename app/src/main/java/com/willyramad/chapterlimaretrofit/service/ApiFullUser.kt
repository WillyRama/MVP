package com.willyramad.chapterlimaretrofit.service

import com.willyramad.chapterlimaretrofit.model.ResponDataUserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiFullUser {

    @GET("user")
    fun getAllUser(): Call<List<ResponDataUserItem>>
}