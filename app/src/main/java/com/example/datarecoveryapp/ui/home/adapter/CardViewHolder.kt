package com.example.datarecoveryapp.ui.home.adapter

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.example.datarecoveryapp.R
import com.example.datarecoveryapp.databinding.CardItemBinding
import com.example.datarecoveryapp.ui.home.interfaces.OnItemClickListener
import com.example.datarecoveryapp.ui.home.model.CardModel

class CardViewHolder(private val binding: CardItemBinding, private val onItemClickListener: OnItemClickListener):
    RecyclerView.ViewHolder(binding.root) {

    fun setData(item: CardModel){
        binding.apply {
            mainCard.setCardBackgroundColor(root.resources.getColor(item.color))
            cardIcon.setImageResource(item.image)
            textRecoverType.text=item.title
            textTotalItems.text=item.items
            root.setOnClickListener{
                onItemClickListener.onClick(item)
            }
        }



    }

}