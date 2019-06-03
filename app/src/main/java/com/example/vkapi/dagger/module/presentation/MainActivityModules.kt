package com.example.vkapi.dagger.module.presentation

import com.example.vkapi.dagger.FragmentScope
import com.example.vkapi.presentation.screen.edit.EditProfileFragment
import com.example.vkapi.presentation.screen.login.LoginViewFragment
import com.example.vkapi.presentation.screen.profile.ProfileViewFragment
import com.example.vkapi.presentation.screen.splashScreen.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModules {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideSplashScreenFragment(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideLoginFragment(): LoginViewFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideProfileFragment(): ProfileViewFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideEditProfileFragment(): EditProfileFragment
}