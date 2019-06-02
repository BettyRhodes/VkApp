package com.example.vkapi.dagger.module.data

import com.example.vkapi.data.converter.Converter
import com.example.vkapi.data.converter.PostConverter
import com.example.vkapi.data.converter.UserRequestConverter
import com.example.vkapi.data.converter.UserResponseConverter
import com.example.vkapi.data.request.ProfileRequest
import com.example.vkapi.data.response.PostResponse
import com.example.vkapi.data.response.ProfileResponse
import com.example.vkapi.domain.entity.Post
import com.example.vkapi.domain.entity.User
import com.example.vkapi.presentation.converter.PostMessageConverter
import com.example.vkapi.presentation.converter.PresentationConverter
import com.example.vkapi.presentation.converter.ProfileConverter
import com.example.vkapi.presentation.converter.TwoWayPresentationConverter
import com.example.vkapi.presentation.models.PostMessage
import com.example.vkapi.presentation.models.Profile
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface ConverterModule {

    @Reusable
    @Binds
    fun bindUserResponseConverter(instance: UserResponseConverter): Converter<ProfileResponse, User>

    @Reusable
    @Binds
    fun bindUserRequestConverter(instance: UserRequestConverter): Converter<User, ProfileRequest>

    @Reusable
    @Binds
    fun bindPostsConverters(instance: PostConverter): Converter<PostResponse, List<Post>>

    @Reusable
    @Binds
    fun bindPostMessageConverter(instance: PostMessageConverter): PresentationConverter<Post, PostMessage>

    @Reusable
    @Binds
    fun bindProfileConverter(instance: ProfileConverter): TwoWayPresentationConverter<User, Profile>
}