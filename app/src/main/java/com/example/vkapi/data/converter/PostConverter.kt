package com.example.vkapi.data.converter

import com.example.vkapi.data.response.PostResponse
import com.example.vkapi.domain.entity.Post
import javax.inject.Inject

class PostConverter @Inject constructor() :
    Converter<@JvmSuppressWildcards List<PostResponse>, @JvmSuppressWildcards List<Post>> {

    override fun convertTo(t: List<PostResponse>): List<Post> = t.map {
        Post(
            it.id,
            it.profileName,
            it.message,
            it.image,
            it.video,
            it.musicName,
            it.musicAuthor,
            it.date,
            it.likes
        )
    }
}