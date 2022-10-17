package com.willyramad.chapterlimaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.willyramad.chapterlimaretrofit.ViewModel.ViewModelCar
import com.willyramad.chapterlimaretrofit.databinding.ActivityUpdateCarBinding

class UpdateCarActivity : AppCompatActivity() {

    lateinit var binding : ActivityUpdateCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnupdate.setOnClickListener {
            var fetId = intent.getIntExtra("Update",0)
            var name = binding.name.text.toString()
            var cat =  binding.category.text.toString()
            var status =  binding.status.text.toString()
            var price = binding.price.text.toString()
            var image =  binding.image.text.toString()
            Log.d("infoid",fetId.toString())
            updateApiCar(fetId,name,cat,status.toBoolean(),price.toInt(),image)
            finish()
        }
    }
    fun updateApiCar(id : Int, name : String, category : String , status : Boolean, price : Int, image : String){
        var viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.updateApiCar(id,name,category,status,price,image)
        viewModel.updLiveDataCar().observe(this, Observer {
            if (it != null) {
                Toast.makeText(this, "Update Data Berhasil", Toast.LENGTH_SHORT).show()
            }
        })
    }
}