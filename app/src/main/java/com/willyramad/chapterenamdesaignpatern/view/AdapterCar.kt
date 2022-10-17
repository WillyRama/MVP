package com.willyramad.chapterenamdesaignpatern.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.willyramad.chapterenamdesaignpatern.databinding.ItemCarBinding
import com.willyramad.chapterenamdesaignpatern.model.GetAllResponCarItem

class AdapterCar(var listCar : List<GetAllResponCarItem>):RecyclerView.Adapter<AdapterCar.ViewHolder>(){
    class ViewHolder (var binding : ItemCarBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =ItemCarBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvHarga.text = listCar[position].price.toString()
        holder.binding.tvNama.text = listCar[position].name
        Glide.with(holder.itemView).load(listCar[position].image).into(holder.binding.tvImg)
    }

    override fun getItemCount(): Int {
        return  listCar.size
    }
}