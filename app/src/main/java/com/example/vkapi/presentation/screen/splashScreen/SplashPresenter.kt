package com.example.vkapi.presentation.screen.splashScreen

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.presentation.common.BasePresenter
import com.example.vkapi.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(private val router: Router) : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            router.newRootScreen(Screen.LoginScreen())
        }, 2000)
    }
}