package com.willyramad.chapterlimaretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.willyramad.chapterlimaretrofit.databinding.ItemUserBinding
import com.willyramad.chapterlimaretrofit.model.ResponDataUserItem

class AdapterUser (var listUser : List<ResponDataUserItem>): RecyclerView.Adapter<AdapterUser.ViewHolder>(){
    class ViewHolder (var binding : ItemUserBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvNama.text = listUser[position].name
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}