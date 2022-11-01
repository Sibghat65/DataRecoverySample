package com.example.datarecoveryapp.ui.imagesdetails.adapter

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datarecoveryapp.R
import com.example.datarecoveryapp.databinding.ImageItemBinding
import com.example.datarecoveryapp.ui.imagesdetails.interfaces.OnItemClick
import com.example.datarecoveryapp.ui.imagesdetails.model.ImageFile

class ImagesViewHolder(private val binding: ImageItemBinding, private val onItemClick: OnItemClick):
    RecyclerView.ViewHolder(binding.root) {

    fun setData(imageFile: ImageFile){
        binding.apply {
            Glide.with(binding.root.context)
                .load(imageFile.file)
                .placeholder(R.drawable.ic_icon_gallery)
                .into(imageView)
            iconTick.visibility= View.GONE
            root.setOnClickListener{
                if(iconTick.isVisible){
                    iconTick.visibility=View.GONE
                    imageFile.isSelected=false
                    imageView.alpha=1F
                }
                else{
                    iconTick.visibility=View.VISIBLE
                    imageFile.isSelected=true
                    imageView.alpha=0.4F
                }
                onItemClick.onClick(imageFile)
            }
        }



    }

}