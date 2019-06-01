package com.example.vkapi.presentation.converter

import com.example.vkapi.domain.entity.Post
import com.example.vkapi.presentation.models.PostMessage
import javax.inject.Inject

class PostMessageConverter @Inject constructor(): PresentationConverter<Post, PostMessage> {
    override fun convertTo(t: Post): PostMessage =
        PostMessage(
            t.id,
            t.profileName,
            t.message,
            t.image,
            t.video,
            t.musicName,
            t.musicAuthor,
            t.date,
            t.likes,
            t.isLiked,
            t.avatar
        )
}