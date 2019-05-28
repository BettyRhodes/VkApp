package com.example.vkapi.presentation.screen.splashScreen

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.domain.repository.SessionRepository
import com.example.vkapi.presentation.common.BasePresenter
import com.example.vkapi.presentation.navigation.Screen
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(
    private val router: Router,
    private val sessionRepository: SessionRepository
) : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

       authApp()

    }

    private fun authApp(){
        Observable.timer(2, TimeUnit.SECONDS, Schedulers.io())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    router.newRootScreen(
                        when(sessionRepository.isAuth()){
                            true -> Screen.ProfileViewScreen()
                            false -> Screen.LoginScreen()
                        }
                    )
                },
                {

                }).untilDestroy()
    }
}