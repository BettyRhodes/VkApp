package com.example.vkapi.dagger

import com.example.vkapi.data.converter.Converter
import com.example.vkapi.data.converter.UserConverter
import com.example.vkapi.data.response.ProfileResponse
import com.example.vkapi.domain.entity.Profile
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface ConverterModule {

    @Reusable
    @Binds
    fun bindUserConverter(instance: UserConverter): Converter<ProfileResponse, Profile>
}