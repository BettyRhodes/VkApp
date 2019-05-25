package com.example.vkapi.presentation.screen.login

import android.text.TextUtils
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.R
import com.example.vkapi.domain.repository.SessionRepository
import com.example.vkapi.presentation.common.BasePresenter
import com.example.vkapi.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class LoginViewPresenter @Inject constructor(
    private val router: Router,
    private val sessionRepository: SessionRepository
) : BasePresenter<LoginView>() {

    fun login(email: String, password: String) {

        when {
            TextUtils.isEmpty(email) -> viewState.showEmailError(message = R.string.emptyField)
            TextUtils.isEmpty(password) -> viewState.showPasswordError(message = R.string.emptyField)
            !validPassword(password) -> viewState.showPasswordError(message = R.string.invalidPassword)
            else -> sessionRepository.login(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        router.replaceScreen(Screen.ProfileViewScreen())
                    },
                    {
                        viewState.showLoginError(message = R.string.loginError)
                    }
                ).untilDestroy()
        }
    }

    // fun login(email: String, password: String){
    //     when {
    //         TextUtils.isEmpty(email) -> viewState.showEmailError(message = R.string.emptyField)
    //         TextUtils.isEmpty(password) -> viewState.showPasswordError(message = R.string.emptyField)
    //         !validPassword(password) -> viewState.showPasswordError(message = R.string.invalidPassword)
    //         password == "1234" ->  router.replaceScreen(Screen.ProfileViewScreen())
    //         else -> viewState.showLoginError(message = R.string.loginError)
    //     }
    // }

    private fun validPassword(password: String): Boolean = password.length >= 3

}