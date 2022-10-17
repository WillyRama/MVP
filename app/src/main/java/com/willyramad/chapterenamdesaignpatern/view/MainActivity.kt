package com.willyramad.chapterenamdesaignpatern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.willyramad.chapterenamdesaignpatern.R
import com.willyramad.chapterenamdesaignpatern.databinding.ActivityMainBinding
import com.willyramad.chapterenamdesaignpatern.model.GetAllResponCarItem
import com.willyramad.chapterenamdesaignpatern.presenter.CarView
import com.willyramad.chapterenamdesaignpatern.presenter.PresenterCar

class MainActivity : AppCompatActivity(), CarView {

    lateinit var binding : ActivityMainBinding
    private lateinit var presenter :  PresenterCar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter =  PresenterCar(this)
        presenter.getDataCar()
    }

    override fun onSuccess(pesan: String, car: List<GetAllResponCarItem>) {
        binding.rvData.layoutManager = LinearLayoutManager(this)
        binding.rvData.adapter = AdapterCar(car)
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
    }
}