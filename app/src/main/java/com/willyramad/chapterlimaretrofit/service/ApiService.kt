package com.willyramad.chapterlimaretrofit.service

import com.willyramad.chapterlimaretrofit.model.DataCar
import com.willyramad.chapterlimaretrofit.model.GetAllCarResponseItem
import com.willyramad.chapterlimaretrofit.model.PostResponCar
import com.willyramad.chapterlimaretrofit.model.PutResponCar
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("admin/car")
    fun getAllcar(): Call<List<GetAllCarResponseItem>>

    @POST("admin/car")
    fun addDataCar(@Body request : DataCar) : Call<PostResponCar>

    @PUT("admin/car/{id}")
    fun updateDataCar(@Path("id")id : Int,@Body request: DataCar): Call<List<PutResponCar>>
}