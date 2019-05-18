package com.example.vkapi.presentation.screen.splashScreen

import com.example.vkapi.App
import com.example.vkapi.R
import com.example.vkapi.presentation.entites.BaseFragment
import com.example.vkapi.presentation.navigation.Screen
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment: BaseFragment(R.layout.fragment_splash){
    override fun onResume() {
        super.onResume()

        startText.postDelayed({
            App.INSTANCE.router.replaceScreen(Screen.LoginScreen())
        }, 2000)
    }
}