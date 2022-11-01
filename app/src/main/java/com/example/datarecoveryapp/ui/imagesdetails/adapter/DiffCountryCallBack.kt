package com.example.datarecoveryapp.ui.imagesdetails.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.datarecoveryapp.ui.home.model.CardModel
import com.example.datarecoveryapp.ui.imagesdetails.model.ImageFile

object DiffCountryCallBack:DiffUtil.ItemCallback<ImageFile>() {
    override fun areItemsTheSame(oldItem: ImageFile, newItem: ImageFile): Boolean {
        return oldItem.file==newItem.file
    }

    override fun areContentsTheSame(oldItem: ImageFile, newItem: ImageFile): Boolean {
        return oldItem==newItem
    }
}