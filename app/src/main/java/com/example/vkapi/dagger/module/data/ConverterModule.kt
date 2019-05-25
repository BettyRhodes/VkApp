package com.example.vkapi.dagger.module.data

import com.example.vkapi.data.converter.Converter
import com.example.vkapi.data.converter.PostConverter
import com.example.vkapi.data.converter.UserConverter
import com.example.vkapi.data.response.PostResponse
import com.example.vkapi.data.response.ProfileResponse
import com.example.vkapi.domain.entity.Post
import com.example.vkapi.domain.entity.User
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface ConverterModule {

    @Reusable
    @Binds
    fun bindUserConverter(instance: UserConverter): Converter<ProfileResponse, User>

    @Reusable
    @Binds
    fun bindPostConverters(instance: PostConverter): Converter<List<PostResponse>, List<Post>>
}