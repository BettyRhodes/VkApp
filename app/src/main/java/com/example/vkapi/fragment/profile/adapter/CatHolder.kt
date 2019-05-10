package com.example.vkapi.fragment.profile.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.vkapi.common.loadImage
import com.example.vkapi.fragment.profile.CatMessage
import kotlinx.android.synthetic.main.item_cat_message.view.*

class CatHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(data: CatMessage){
        itemView.itemCatMessage.loadImage(data.image)
    }
}