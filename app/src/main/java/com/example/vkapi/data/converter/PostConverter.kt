package com.example.vkapi.data.converter

import com.example.vkapi.data.response.PostResponse
import com.example.vkapi.domain.entity.PostMessage
import javax.inject.Inject

class PostConverter @Inject constructor(): Converter<PostResponse, List<PostMessage>>{

    override fun convertFrom(k: List<PostMessage>): PostResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun convertTo(t: PostResponse): List<PostMessage> = listOf(
        PostMessage(
        t.id,
        t.profileName,
        t.message,
        t.image,
        t.video,
        t.musicName,
        t.musicAuthor,
        t.date,
        t.likes
    )
    )

}