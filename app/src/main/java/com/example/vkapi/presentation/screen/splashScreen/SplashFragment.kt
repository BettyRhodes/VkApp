package com.example.vkapi.presentation.screen.splashScreen

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.vkapi.App
import com.example.vkapi.R
import com.example.vkapi.presentation.entites.BaseFragment
import com.example.vkapi.presentation.navigation.Screen
import kotlinx.android.synthetic.main.fragment_splash.*
import org.koin.android.ext.android.get

class SplashFragment: BaseFragment(R.layout.fragment_splash){

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter = get()
}