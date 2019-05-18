package com.example.vkapi.presentation.entites

import com.example.vkapi.presentation.entites.BaseItem

class PostMessage(
    id: Int,
    val profileName: String,
    val message: String,
    val image: String,
    val video: String,
    val musicName: String,
    val musicAuthor: String,
    val date: String,
    val likes: Int
): BaseItem(id)