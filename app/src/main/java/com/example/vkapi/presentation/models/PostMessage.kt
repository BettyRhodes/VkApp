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
    var likes: Int,
    var isLiked: Boolean,
    val avatar: String
): BaseItem(id)