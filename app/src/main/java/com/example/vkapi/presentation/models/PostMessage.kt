package com.example.vkapi.presentation.models

class PostMessage(
    id: Int,
    val profileName: String,
    val message: String,
    val image: String,
    val video: String,
    val musicName: String,
    val musicAuthor: String,
    val date: String,
    val likes: Int,
    val avatar: String
): BaseItem(id)