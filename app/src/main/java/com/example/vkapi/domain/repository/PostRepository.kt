package com.example.vkapi.domain.repository

import com.example.vkapi.presentation.models.PostMessage

interface PostRepository {

    //fun getAll(): Single<List<PostMessage>>
    fun getAll(): List<PostMessage>
    fun getPost(id: Int): PostMessage
}