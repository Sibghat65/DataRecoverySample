package com.example.datarecoveryapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.datarecoveryapp.databinding.CardItemBinding
import com.example.datarecoveryapp.ui.home.interfaces.OnItemClickListener
import com.example.datarecoveryapp.ui.home.model.CardModel
import com.example.datarecoveryapp.ui.imagesdetails.adapter.ImagesViewHolder

class CardsAdapter(private val onItemClickListener: OnItemClickListener)
    :ListAdapter<CardModel, CardViewHolder>(DiffCountryCallBack){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding=CardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardViewHolder(binding,onItemClickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
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
