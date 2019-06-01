package com.example.vkapi.presentation.screen.profile.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vkapi.R
import com.example.vkapi.presentation.models.BaseItem
import com.example.vkapi.presentation.models.PostMessage
import com.example.vkapi.presentation.models.Profile
import com.example.vkapi.presentation.extensions.inflate
import com.example.vkapi.presentation.extensions.loadImage
import kotlinx.android.synthetic.main.item_post_message.view.*
import kotlin.IllegalArgumentException

class FeedAdapter(private val loadPosts: () -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val PROFILE = 1
        const val POST_MESSAGE = 2
    }

    private val items: MutableList<BaseItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType){
            PROFILE -> ProfileHolder(
                parent.inflate(R.layout.item_profile)
            )

            POST_MESSAGE -> PostMessageHolder(
                parent.inflate(R.layout.item_post_message)
            )

            else -> throw IllegalArgumentException("viewType: $viewType is not found")
        }

    override fun getItemViewType(position: Int): Int = when(items[position]) {
        is Profile -> PROFILE
        is PostMessage -> POST_MESSAGE
        else -> throw IllegalArgumentException("${items[position].javaClass} is not found")
    }

  //  fun setProfile(profile: Profile){
  //      if (items.isEmpty()) {
  //          items.add(profile)
  //      } else {
  //          this.items[0] = profile
  //      }
  //      notifyItemChanged(0)
  //  }

    fun setProfile(profile: Profile, onFirstAttach: () -> Unit) {
        if (items.isNotEmpty() && items[0] is Profile) {
            items[0] = profile
            notifyItemChanged(0)
        } else {
            items.add(0, profile)
            notifyItemInserted(0)
            onFirstAttach()
        }
    }

    fun setItems(items: List<BaseItem>){
        var profile: BaseItem? = null
        if (items.isNotEmpty() && items[0] is Profile) {
            profile = this.items[0]
        }
        this.items.clear()
        profile?.let { this.items.add(it) }
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(items.size - position == 5)
            loadPosts()

        when(holder){
            is ProfileHolder -> holder.bind(items[position] as Profile)
            is PostMessageHolder -> {
                holder.bind(items[position] as PostMessage)
            }
        }
    }

   inner class PostMessageHolder(view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("ResourceAsColor", "TimberArgCount")
        fun bind(data: PostMessage) {
            itemView.profileName.text = data.profileName
            itemView.itemPostMessage.text = data.message
            itemView.postDate.text = data.date
            itemView.likes.text = data.likes.toString()
            itemView.profileImage.loadImage(data.avatar)
            itemView.itemPostImage.visibility = View.GONE
            itemView.itemPostMessage.visibility = View.GONE
            itemView.itemPostMusic.visibility = View.GONE
            itemView.itemVideo.visibility = View.GONE

            itemView.likesButton.setOnClickListener {
                if(data.isLiked)
                    data.likes--
                else
                    data.likes++

                data.isLiked = !data.isLiked
                notifyItemChanged(adapterPosition, true)
            }

            if (data.isLiked) {
                itemView.likesButton.setImageResource(R.drawable.ic_liked)
                itemView.likes.setTextColor(Color.RED)
            } else {
                itemView.likesButton.setImageResource(R.drawable.ic_like)
                itemView.likes.setTextColor(Color.GRAY)
            }

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

}