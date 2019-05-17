package com.example.vkapi.fragment.profile.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vkapi.R
import com.example.vkapi.entites.BaseItem
import com.example.vkapi.entites.Profile
import com.example.vkapi.extensions.inflate
import com.example.vkapi.entites.PostMessage
import kotlin.IllegalArgumentException

class FeedAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val PROFILE = 1
        const val POST_MESSAGE = 2
    }

    private val items: MutableList<BaseItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType){
            PROFILE -> ProfileHolder(parent.inflate(R.layout.item_profile, false))

            POST_MESSAGE -> PostMessageHolder(parent.inflate(R.layout.item_post_message, false))

            else -> throw IllegalArgumentException("viewType: $viewType is not found")
        }

    override fun getItemViewType(position: Int): Int = when(items[position]) {
        is Profile -> PROFILE
        is PostMessage -> POST_MESSAGE
        else -> throw IllegalArgumentException("${items[position].javaClass} is not found")
    }

    fun setProfile(profile: Profile){
        if (items.isEmpty()) {
            items.add(profile)
        } else {
            this.items[0] = profile
        }
        notifyItemChanged(0)
    }

    fun setItems(items: List<BaseItem>){
        val profile = this.items[0]
        this.items.clear()
        this.items.add(profile)
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ProfileHolder -> holder.bind(items[position] as Profile)
            is PostMessageHolder -> holder.bind(items[position] as PostMessage)
        }
    }
}