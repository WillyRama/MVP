package com.willyramad.chapterenamdesaignpatern.service

import com.willyramad.chapterenamdesaignpatern.model.GetAllResponCar
import com.willyramad.chapterenamdesaignpatern.model.GetAllResponCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("admin/car")
    fun getAllCar(): Call<List<GetAllResponCarItem>>
}