package com.example.vkapi.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String){
    Glide.with(this).load(url).into(this)
}

fun loadViewHolder(layoutId: Int, viewGroup: ViewGroup, attachToRoot: Boolean): View {
    return LayoutInflater.from(viewGroup.context).inflate(layoutId, viewGroup, attachToRoot)
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean): View =
    LayoutInflater.from(context)
        .inflate(layoutId, this, attachToRoot)
