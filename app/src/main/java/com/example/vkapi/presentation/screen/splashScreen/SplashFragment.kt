package com.example.vkapi.presentation.screen.splashScreen

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.vkapi.R
import com.example.vkapi.presentation.entites.BaseFragment
import javax.inject.Inject

class SplashFragment: BaseFragment(R.layout.fragment_splash), SplashView{

    @Inject
    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter = presenter
}