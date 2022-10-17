package com.willyramad.chapterlimaretrofit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.willyramad.chapterlimaretrofit.databinding.ItemMobilBinding
import com.willyramad.chapterlimaretrofit.model.GetAllCarResponseItem

class Adapter(var listCar : List<GetAllCarResponseItem>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder (var binding : ItemMobilBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMobilBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvHarga.text = listCar[position].price.toString()
        holder.binding.tvNama.text = listCar[position].name
        Glide.with(holder.itemView).load(listCar[position].image).into(holder.binding.tvImg)
        holder.binding.Klik.setOnClickListener {
            var edit = Intent(it.context, UpdateCarActivity::class.java)
            edit.putExtra("Update", listCar[position].id)
            it.context.startActivity(edit)
        }
    }

    override fun getItemCount(): Int {
        return listCar.size
    }
}