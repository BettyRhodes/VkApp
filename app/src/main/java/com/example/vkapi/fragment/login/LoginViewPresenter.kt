package com.example.vkapi.fragment.login

import android.text.TextUtils
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vkapi.App
import com.example.vkapi.R
import com.example.vkapi.navigation.Screen

@InjectViewState
class LoginViewPresenter: MvpPresenter<LoginView>() {

    fun login(email: String, password: String){
        when {
            TextUtils.isEmpty(email) -> viewState.showLoginError(message = R.string.emptyEmail)
            TextUtils.isEmpty(password) -> viewState.showLoginError(message = R.string.emptyPassword)
            password == "1" ->  App.INSTANCE.router.replaceScreen(Screen.ProfileViewScreen())
            else -> viewState.showLoginError(message = R.string.loginError)
        }
    }

}