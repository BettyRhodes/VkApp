package com.example.vkapi.data.converter

import com.example.vkapi.data.response.PostResponse
import com.example.vkapi.domain.entity.Post
import javax.inject.Inject

class PostConverter @Inject constructor() :
    Converter<@JvmSuppressWildcards PostResponse, List<@JvmSuppressWildcards Post>> {

    override fun convertTo(t: PostResponse): List<Post> = t.posts.map {
        Post(
            it.id,
            it.profileName,
            it.message,
            it.image,
            it.video,
            it.musicName,
            it.musicAuthor,
            it.date,
            it.likes,
            it.avatar
        )
    }
}