package com.example.vkapi.domain.repository

import com.example.vkapi.domain.entity.Post
import io.reactivex.Single

interface PostRepository {

    fun getPosts(): Single<List<Post>>
    fun getPost(id: Int): Post
}