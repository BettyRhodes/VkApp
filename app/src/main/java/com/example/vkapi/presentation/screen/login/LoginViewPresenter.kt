package com.example.vkapi.presentation.screen.login

import android.text.TextUtils
import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.R
import com.example.vkapi.presentation.entites.BasePresenter
import com.example.vkapi.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class LoginViewPresenter @Inject constructor(private val router: Router): BasePresenter<LoginView>() {

    fun login(email: String, password: String){
        when {
            TextUtils.isEmpty(email) -> viewState.showEmailError(message = R.string.emptyField)
            TextUtils.isEmpty(password) -> viewState.showPasswordError(message = R.string.emptyField)
            !validPassword(password) -> viewState.showPasswordError(message = R.string.invalidPassword)
            password == "123456" ->  router.replaceScreen(Screen.ProfileViewScreen())
            else -> viewState.showLoginError(message = R.string.loginError)
        }
    }

    private fun validPassword(password: String): Boolean = password.length >= 3

}