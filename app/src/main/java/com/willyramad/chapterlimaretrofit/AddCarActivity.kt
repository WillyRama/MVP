package com.willyramad.chapterlimaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.willyramad.chapterlimaretrofit.ViewModel.ViewModelCar
import com.willyramad.chapterlimaretrofit.databinding.ActivityAddCarBinding

class AddCarActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddCarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnadd.setOnClickListener {
            var name = binding.name.text.toString()
            var cat =  binding.category.text.toString()
            var status =  binding.status.text.toString()
            var price = binding.price.text.toString()
            var image =  binding.image.text.toString()
            addCar(name,cat,status.toBoolean(),price.toInt(),image)
        }
    }
    fun addCar(name : String, category : String , status : Boolean, price : Int, image : String){
        var viewmodel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewmodel.callPostApiCar(name, category,status,price,image )
        viewmodel.postLiveDataCar().observe(this, Observer{
            if (it != null) {
                Toast.makeText(this, "Tambah Data Berhasil", Toast.LENGTH_SHORT).show()
            }
        })
    }

}