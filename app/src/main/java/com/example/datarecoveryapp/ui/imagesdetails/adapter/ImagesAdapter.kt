package com.example.datarecoveryapp.ui.imagesdetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.datarecoveryapp.databinding.ImageItemBinding
import com.example.datarecoveryapp.ui.imagesdetails.interfaces.OnItemClick
import com.example.datarecoveryapp.ui.imagesdetails.model.ImageFile

class ImagesAdapter(private val onItemClick: OnItemClick)
    :ListAdapter<ImageFile, ImagesViewHolder>(DiffCountryCallBack){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val binding=ImageItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImagesViewHolder(binding,onItemClick)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val currentItem=getItem(position)
        holder.setData(currentItem)
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


}
