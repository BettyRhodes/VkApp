package com.example.vkapi.presentation.screen.profile.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.vkapi.presentation.models.Profile
import kotlinx.android.synthetic.main.item_profile.view.*

class ProfileHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(data: Profile){
        itemView.profileStatus.text = data.status
        itemView.profileHome.text = data.home
        itemView.profileBirthday.text = data.birthday
    }
}