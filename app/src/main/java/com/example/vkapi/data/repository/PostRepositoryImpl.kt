package com.example.vkapi.data.repository

import com.example.vkapi.data.converter.PostConverter
import com.example.vkapi.data.datasource.PostsDataSource
import com.example.vkapi.data.network.Api
import com.example.vkapi.domain.entity.Post
import com.example.vkapi.domain.repository.PostRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postsDataSource: PostsDataSource,
    private val postConverter: PostConverter
): PostRepository {

    override fun getPost(id: Int): Post {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPosts(page: Int): Single<List<Post>> = postsDataSource.getPosts(1, page)
        .subscribeOn(Schedulers.io())
        .map(postConverter::convertTo)
}