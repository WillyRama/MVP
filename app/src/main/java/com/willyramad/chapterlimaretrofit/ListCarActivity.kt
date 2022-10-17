package com.willyramad.chapterlimaretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.willyramad.chapterlimaretrofit.databinding.ActivityListCarBinding
import com.willyramad.chapterlimaretrofit.model.GetAllCarResponseItem
import com.willyramad.chapterlimaretrofit.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCarActivity : AppCompatActivity() {
    lateinit var binding: ActivityListCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListCarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDataCar()
        binding.btntambah.setOnClickListener{
            startActivity(Intent(this, AddCarActivity::class.java))
        }
    }

    fun showDataCar(){
        ApiClient.instance.getAllcar()
            .enqueue(object  : Callback<List<GetAllCarResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCarResponseItem>>,
                    response: Response<List<GetAllCarResponseItem>>
                ) {
                    if (response.isSuccessful){
                        binding.rvMobil.layoutManager = LinearLayoutManager(this@ListCarActivity, LinearLayoutManager.VERTICAL,false)
                        binding.rvMobil.adapter = Adapter(response.body()!!)
                    }else{
                        Toast.makeText(this@ListCarActivity, "Data Kosong", Toast.LENGTH_SHORT).show()

                    }
                }

                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                    Toast.makeText(this@ListCarActivity, "Kesalahan", Toast.LENGTH_SHORT).show()

                }

            })
    }
}