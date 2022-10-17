package com.willyramad.chapterlimaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.willyramad.chapterlimaretrofit.ViewModel.ViewModelUser
import com.willyramad.chapterlimaretrofit.databinding.ActivityListUserBinding

class ListUserActivity : AppCompatActivity() {
    lateinit var binding : ActivityListUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tampilData()
    }
    fun tampilData(){
        val VmUser = ViewModelProvider(this).get(ViewModelUser::class.java)

        VmUser.callUser()
        VmUser.ambilDataUser().observe(this) {
            if (it != null)
                binding.rvUser.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                binding.rvUser.adapter = AdapterUser(it)
        }
    }
}