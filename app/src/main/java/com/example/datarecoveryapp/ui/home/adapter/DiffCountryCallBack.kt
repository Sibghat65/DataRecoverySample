package com.example.datarecoveryapp.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.datarecoveryapp.ui.home.model.CardModel

object DiffCountryCallBack:DiffUtil.ItemCallback<CardModel>() {
    override fun areItemsTheSame(oldItem: CardModel, newItem: CardModel): Boolean {
        return oldItem.items==newItem.items
    }

    override fun areContentsTheSame(oldItem: CardModel, newItem: CardModel): Boolean {
        return oldItem==newItem
    }
}