package com.example.vkapi.dagger

import com.example.vkapi.presentation.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModules::class])
    fun provideMainActivity(): MainActivity
}