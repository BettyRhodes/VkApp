package com.example.vkapi.dagger.module.presentation

import dagger.Module

@Module(
    includes = [
        AppModule::class,
        MainActivityModules::class,
        NavigationModule::class]
)
interface PresentationModule {
}