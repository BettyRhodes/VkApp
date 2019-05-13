package com.example.vkapi.fragment.profile.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.vkapi.common.loadImage
import com.example.vkapi.fragment.profile.messages.PostMessage
import kotlinx.android.synthetic.main.item_post_message.view.*

class PostMessageHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(data: PostMessage){
        itemView.itemPostMessage.text = data.message

        if(data.image.isNotEmpty())
            itemView.itemPostImage.loadImage(data.image)
    }
}