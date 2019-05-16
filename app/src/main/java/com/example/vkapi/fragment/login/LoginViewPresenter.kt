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
            TextUtils.isEmpty(email) -> viewState.showEmailError(message = R.string.emptyField)
            TextUtils.isEmpty(password) -> viewState.showPasswordError(message = R.string.emptyField)
            !isValidPassword(password) -> viewState.showPasswordError(message = R.string.invalidPassword)
            password == "123456" ->  App.INSTANCE.router.replaceScreen(Screen.ProfileViewScreen())
            else -> viewState.showLoginError(message = R.string.loginError)
        }
    }

    private fun isValidPassword(password: String): Boolean = password.length >= 6

}