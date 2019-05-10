package com.example.vkapi.navigation

import androidx.fragment.app.Fragment
import com.example.vkapi.fragment.edit.EditProfileFragment
import com.example.vkapi.fragment.login.LoginViewFragment
import com.example.vkapi.fragment.profile.ProfileViewFragment
import com.example.vkapi.fragment.splashScreen.SplashFragment
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