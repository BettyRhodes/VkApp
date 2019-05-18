package com.example.vkapi.dagger

import com.example.vkapi.data.repository.PostRepositoryImpl
import com.example.vkapi.data.repository.ProfileRepositoryImpl
import com.example.vkapi.domain.repository.PostRepository
import com.example.vkapi.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface DataModule {

    @Reusable
    @Binds
    fun bindPostRepository(instance: PostRepositoryImpl): PostRepository

    @Reusable
    @Binds
    fun bindProfileRepository(instance: ProfileRepositoryImpl): ProfileRepository
}