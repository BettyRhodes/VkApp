package com.example.vkapi.dagger.module.data

import android.content.Context
import android.content.SharedPreferences
import com.example.vkapi.App
import com.example.vkapi.data.datasource.*
import com.example.vkapi.data.repository.PostRepositoryImpl
import com.example.vkapi.data.repository.ProfileRepositoryImpl
import com.example.vkapi.data.repository.SessionRepositoryImpl
import com.example.vkapi.domain.repository.PostRepository
import com.example.vkapi.domain.repository.ProfileRepository
import com.example.vkapi.domain.repository.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(
    includes = [
        ConverterModule::class,
        NetworkModule::class]
)
abstract class DataModule {

    @Module
    companion object{

        @JvmStatic
        @Reusable
        @Provides
        fun provideSharedPreferences(app: App): SharedPreferences =
                app.getSharedPreferences("CommonSharedPreferences", Context.MODE_PRIVATE)
    }

    @Reusable
    @Binds
    abstract fun bindAuthDataSource(instance: AuthDataSourceImpl): AuthDataSource

    @Reusable
    @Binds
    abstract fun bindPostsDataSource(instance: PostsDataSourceImpl): PostsDataSource

    @Reusable
    @Binds
    abstract fun bindProfileDataSource(instance: ProfileDataSourceImpl): ProfileDataSource

    @Reusable
    @Binds
    abstract fun bindSessionDataSource(instance: SessionDataSourceImpl): SessionDataSource

    @Reusable
    @Binds
    abstract fun bindPostRepository(instance: PostRepositoryImpl): PostRepository

    @Reusable
    @Binds
    abstract fun bindProfileRepository(instance: ProfileRepositoryImpl): ProfileRepository

    @Reusable
    @Binds
    abstract fun bindSessionRepository(instance: SessionRepositoryImpl): SessionRepository
}