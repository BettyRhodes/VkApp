package com.example.vkapi.fragment.profile.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vkapi.R
import com.example.vkapi.common.inflate
import com.example.vkapi.fragment.profile.messages.BaseMessage
import com.example.vkapi.fragment.profile.messages.CatMessage
import com.example.vkapi.fragment.profile.messages.PostMessage
import kotlin.IllegalArgumentException

class FeedAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val POST_MESSAGE = 1
        const val CAT_MESSAGE = 2
    }

    private val items: MutableList<BaseMessage> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType){
            POST_MESSAGE -> PostMessageHolder(parent.inflate(R.layout.item_post_message, false))

            CAT_MESSAGE -> CatHolder(parent.inflate(R.layout.item_cat_message, false))

            else -> throw IllegalArgumentException("viewType: $viewType is not found")
        }

    override fun getItemViewType(position: Int): Int = when(items[position]) {
        is PostMessage -> POST_MESSAGE
        is CatMessage -> CAT_MESSAGE
        else -> throw IllegalArgumentException("${items[position].javaClass} is not found")
    }

    fun setItems(items: List<BaseMessage>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PostMessageHolder -> holder.bind(items[position] as PostMessage)
            is CatHolder -> holder.bind(items[position] as CatMessage)
        }
    }
}