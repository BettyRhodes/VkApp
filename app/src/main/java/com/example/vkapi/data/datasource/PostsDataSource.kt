package com.example.vkapi.data.datasource

import com.example.vkapi.dagger.MockQualifier
import com.example.vkapi.data.network.Api
import com.example.vkapi.data.response.PostResponse
import io.reactivex.Single
import javax.inject.Inject

interface PostsDataSource {
    fun getPosts(userId: Int, page: Int): Single<PostResponse>
}

class PostsDataSourceImpl @Inject constructor(@MockQualifier private val api: Api): PostsDataSource{
    override fun getPosts(userId: Int, page: Int): Single<PostResponse> =
            api.getPosts(userId, page)

}