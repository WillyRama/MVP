package com.willyramad.chapterlimaretrofit.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.willyramad.chapterlimaretrofit.model.DataCar
import com.willyramad.chapterlimaretrofit.model.GetAllCarResponseItem
import com.willyramad.chapterlimaretrofit.model.PostResponCar
import com.willyramad.chapterlimaretrofit.model.PutResponCar
import com.willyramad.chapterlimaretrofit.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCar : ViewModel() {

    lateinit var  liveDataCar : MutableLiveData<List<GetAllCarResponseItem>>
    lateinit var postDCar : MutableLiveData<PostResponCar>
    lateinit var updateCar : MutableLiveData<List<PutResponCar>>

    init {
        liveDataCar = MutableLiveData()
        postDCar = MutableLiveData()
        updateCar = MutableLiveData()
    }

    fun getLiveDataCa():MutableLiveData<List<GetAllCarResponseItem>>{
        return liveDataCar
    }
    fun postLiveDataCar(): MutableLiveData<PostResponCar>{
        return postDCar
    }
    fun updLiveDataCar():MutableLiveData<List<PutResponCar>>{
        return updateCar
    }
    fun updateApiCar(id : Int, name : String, category : String , status : Boolean, price : Int, image : String) {
        ApiClient.instance.updateDataCar(id, DataCar(name, category, price, status, image))
            .enqueue(object : Callback<List<PutResponCar>>{
                override fun onResponse(
                    call: Call<List<PutResponCar>>,
                    response: Response<List<PutResponCar>>
                ) {
                    if (response.isSuccessful) {
                        updateCar.postValue(response.body())
                    } else {
                        updateCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<PutResponCar>>, t: Throwable) {
                    updateCar.postValue(null)
                }

            })
    }

    fun callPostApiCar(name : String, category : String , status : Boolean, price : Int, image : String){
        ApiClient.instance.addDataCar(DataCar(name, category,price, status,image ))
            .enqueue(object  : Callback<PostResponCar>{
                override fun onResponse(
                    call: Call<PostResponCar>,
                    response: Response<PostResponCar>
                ) {
                    if (response.isSuccessful){
                        postDCar.postValue(response.body())
                    }else{
                        postDCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<PostResponCar>, t: Throwable) {
                    postDCar.postValue(null)
                }

            })
    }
    fun callCar(){
        ApiClient.instance.getAllcar()
            .enqueue(object  : Callback<List<GetAllCarResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllCarResponseItem>>,
                    response: Response<List<GetAllCarResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCar.postValue(response.body())
                }else
                {
                    liveDataCar.postValue(null)
                }
            }

                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                    liveDataCar.postValue(null)
                }

            })
    }
}