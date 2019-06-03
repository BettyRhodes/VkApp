package com.example.vkapi.dagger.module.presentation

import com.example.vkapi.dagger.ActivityScope
import com.example.vkapi.presentation.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModules::class])
    fun provideMainActivity(): MainActivity
}