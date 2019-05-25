package com.example.vkapi.dagger

import com.example.vkapi.App
import com.example.vkapi.dagger.module.presentation.AppModule
import com.example.vkapi.dagger.module.data.DataModule
import com.example.vkapi.dagger.module.presentation.NavigationModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NavigationModule::class,
        DataModule::class,
        AndroidSupportInjectionModule::class
    ])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Builder : AndroidInjector.Factory<App>
}