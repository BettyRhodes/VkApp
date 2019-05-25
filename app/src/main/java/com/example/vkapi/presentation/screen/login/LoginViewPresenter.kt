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

        if(TextUtils.isEmpty(email)) {
            viewState.showEmailError(message = R.string.emptyField)
            return
        }

        if(TextUtils.isEmpty(password)){
            viewState.showPasswordError(message = R.string.emptyField)
            return
        }

        if(!validPassword(password)){
            viewState.showPasswordError(message = R.string.invalidPassword)
            return
        }

        //C появлением api перенести роутер
        sessionRepository.login(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {

                    },
                    {
                        router.newRootScreen(Screen.ProfileViewScreen())
                     //   viewState.showLoginError(message = R.string.loginError)
                        Log.d("TAG", it.message.toString())
                    }
                ).untilDestroy()

    }

    private fun validPassword(password: String): Boolean = password.length >= 3

}