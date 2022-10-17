package com.willyramad.chapterlimaretrofit.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.willyramad.chapterlimaretrofit.model.GetAllCarResponseItem
import com.willyramad.chapterlimaretrofit.model.ResponDataUserItem
import com.willyramad.chapterlimaretrofit.service.ApiClient
import com.willyramad.chapterlimaretrofit.service.ApiUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser : ViewModel() {
    lateinit var  liveDataUser : MutableLiveData<List<ResponDataUserItem>>

    init {
        liveDataUser = MutableLiveData()
    }

    fun ambilDataUser(): MutableLiveData<List<ResponDataUserItem>> {
        return liveDataUser
    }
    fun callUser(){
       ApiUser.instance.getAllUser()
           .enqueue(object : Callback<List<ResponDataUserItem>>{
               override fun onResponse(
                   call: Call<List<ResponDataUserItem>>,
                   response: Response<List<ResponDataUserItem>>
               ) {
                   if (response.isSuccessful) {
                       liveDataUser.postValue(response.body())
                   } else {
                       liveDataUser.postValue(null)
                   }
               }

               override fun onFailure(call: Call<List<ResponDataUserItem>>, t: Throwable) {
                   liveDataUser.postValue(null)
               }

           })
    }
}