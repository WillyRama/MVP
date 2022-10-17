package com.willyramad.chapterlimaretrofit.model


import com.google.gson.annotations.SerializedName

data class PostResponCar(
    @SerializedName("category")
    val category: Any,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("finish_rent_at")
    val finishRentAt: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Any,
    @SerializedName("name")
    val name: Any,
    @SerializedName("price")
    val price: Any,
    @SerializedName("start_rent_at")
    val startRentAt: Any,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("updatedAt")
    val updatedAt: String
)