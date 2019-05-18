package com.example.vkapi.presentation.screen.profile.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.vkapi.presentation.models.PostMessage
import com.example.vkapi.presentation.extensions.loadImage
import kotlinx.android.synthetic.main.item_post_message.view.*

class PostMessageHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(data: PostMessage) {
        itemView.itemPostMessage.text = data.message
        itemView.postDate.text = data.date
        itemView.likes.text = data.likes.toString()

        if (data.image.isNotEmpty()) {
            itemView.itemPostImage.loadImage(data.image)
            itemView.itemPostImage.visibility = View.VISIBLE
        }

        if (data.message.isNotEmpty()) {
            itemView.itemPostMessage.text = data.message
            itemView.itemPostMessage.visibility = View.VISIBLE
        }

        if (data.musicAuthor.isNotEmpty() && data.musicName.isNotEmpty()) {
            itemView.itemPostMusic.visibility = View.VISIBLE
            itemView.musicAuthor.text = data.musicAuthor
            itemView.nameMusic.text = data.musicName
        }

        if (data.video.isNotEmpty()) {
            itemView.itemVideo.visibility = View.VISIBLE
        }
    }
}