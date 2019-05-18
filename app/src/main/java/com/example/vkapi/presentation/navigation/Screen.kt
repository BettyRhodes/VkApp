package com.example.vkapi.presentation.navigation

import androidx.fragment.app.Fragment
import com.example.vkapi.presentation.EditProfileFragment
import com.example.vkapi.presentation.login.LoginViewFragment
import com.example.vkapi.presentation.profile.ProfileViewFragment
import com.example.vkapi.presentation.fragment.splashScreen.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment): BaseScreen(fragment) {
    class SplashScreen: Screen(SplashFragment())
    class ProfileViewScreen: Screen(ProfileViewFragment())
    class LoginScreen: Screen(LoginViewFragment())
    class EditScreen: Screen(EditProfileFragment())
}

open class BaseScreen(private val fragment: Fragment): SupportAppScreen(){
    override fun getFragment(): Fragment = fragment
}