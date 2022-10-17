package com.willyramad.chapterlimaretrofit.model


import com.google.gson.annotations.SerializedName

data class ResponDataUserItem(
    @SerializedName("address")
    val address: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)