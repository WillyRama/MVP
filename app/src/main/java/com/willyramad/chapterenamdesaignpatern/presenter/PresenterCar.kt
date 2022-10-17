package com.willyramad.chapterenamdesaignpatern.presenter

import com.willyramad.chapterenamdesaignpatern.model.GetAllResponCarItem
import com.willyramad.chapterenamdesaignpatern.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterCar(val view: CarView) {
    fun getDataCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<GetAllResponCarItem>>{
                override fun onResponse(
                    call: Call<List<GetAllResponCarItem>>,
                    response: Response<List<GetAllResponCarItem>>
                ) {
                    if (response.isSuccessful){
                        view.onSuccess(response.message(),response.body()!!)
                    }else{
                        view.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetAllResponCarItem>>, t: Throwable) {
                    view.onError(t.message!!)
                }

            })
    }
}