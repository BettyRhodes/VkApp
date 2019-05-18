package com.example.vkapi.presentation.screen.login

import android.text.TextUtils
import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.R
import com.example.vkapi.presentation.entites.BasePresenter
import com.example.vkapi.presentation.navigation.Screen
import ru.terrakok.cicerone.Router


@InjectViewState
class LoginViewPresenter(private val router: Router): BasePresenter<LoginView>() {

    fun login(email: String, password: String){
        when {
            TextUtils.isEmpty(email) -> viewState.showEmailError(message = R.string.emptyField)
            TextUtils.isEmpty(password) -> viewState.showPasswordError(message = R.string.emptyField)
            !isValidPassword(password) -> viewState.showPasswordError(message = R.string.invalidPassword)
            password == "123456" ->  router.replaceScreen(Screen.ProfileViewScreen())
            else -> viewState.showLoginError(message = R.string.loginError)
        }
    }

    private fun isValidPassword(password: String): Boolean = password.length >= 6

}