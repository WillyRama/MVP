package com.willyramad.chapterlimaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.willyramad.chapterlimaretrofit.ViewModel.ViewModelCar
import com.willyramad.chapterlimaretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showData()
    }
    fun showData(){
        val viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)

        viewModel.callCar()
        viewModel.getLiveDataCa().observe(this,{
            if (it!=null)
                binding.rvLiveData.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            binding.rvLiveData.adapter =  Adapter(it)
        })
    }
}