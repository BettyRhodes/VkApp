package com.example.vkapi.presentation.screen.profile.adapter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.vkapi.R
import com.example.vkapi.presentation.models.PostMessage
import com.example.vkapi.presentation.extensions.loadImage
import kotlinx.android.synthetic.main.item_post_message.view.*

//class PostMessageHolder(view: View) : RecyclerView.ViewHolder(view) {
//
// //   fun setLike(data: PostMessage){
// //       itemView.likesButton.setOnClickListener {
// //           if (data.isLiked == "liked") {
// //               data.isLiked = "unlike"
// //                          }else{
// //               data.isLiked = "liked"
// //                          }
// //                  }
// //              }
//
//    fun bind(data: PostMessage) {
//        itemView.profileName.text = data.profileName
//        itemView.itemPostMessage.text = data.message
//        itemView.postDate.text = data.date
//        itemView.likes.text = data.likes.toString()
//        itemView.profileImage.loadImage(data.avatar)
//        itemView.itemPostImage.visibility = View.GONE
//        itemView.itemPostMessage.visibility = View.GONE
//        itemView.itemPostMusic.visibility = View.GONE
//        itemView.itemVideo.visibility = View.GONE
//
//        itemView.likesButton.setOnClickListener {
//            data.isLiked = !data.isLiked
//        }
//
//        if (data.isLiked) {
//            itemView.likesButton.setImageResource(R.drawable.ic_liked)
//            itemView.likes.setTextColor(Color.RED)
//        } else {
//            itemView.likesButton.setImageResource(R.drawable.ic_like)
//            itemView.likes.setTextColor(Color.GRAY)
//        }
//
//        if (data.image.isNotEmpty()) {
//            itemView.itemPostImage.loadImage(data.image)
//            itemView.itemPostImage.visibility = View.VISIBLE
//        }
//
//        if (data.message.isNotEmpty()) {
//            itemView.itemPostMessage.text = data.message
//            itemView.itemPostMessage.visibility = View.VISIBLE
//        }
//
//        if (data.musicAuthor.isNotEmpty() && data.musicName.isNotEmpty()) {
//            itemView.itemPostMusic.visibility = View.VISIBLE
//            itemView.musicAuthor.text = data.musicAuthor
//            itemView.nameMusic.text = data.musicName
//        }
//
//        if (data.video.isNotEmpty()) {
//            itemView.itemVideo.visibility = View.VISIBLE
//        }
//    }
//}