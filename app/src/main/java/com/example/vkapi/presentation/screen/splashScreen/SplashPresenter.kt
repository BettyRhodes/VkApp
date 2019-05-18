package com.example.vkapi.presentation.screen.splashScreen

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.presentation.entites.BasePresenter
import com.example.vkapi.presentation.navigation.Screen
import ru.terrakok.cicerone.Router

@InjectViewState
class SplashPresenter(private val router: Router) : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            router.newRootScreen(Screen.ProfileViewScreen())
        }, 2000)
    }
}