package com.example.vkapi.presentation

import com.example.vkapi.presentation.screen.edit.EditProfilePresenter
import com.example.vkapi.presentation.screen.login.LoginViewPresenter
import com.example.vkapi.presentation.screen.main.MainPresenter
import com.example.vkapi.presentation.screen.profile.ProfileViewPresenter
import com.example.vkapi.presentation.screen.splashScreen.SplashPresenter
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val presentationModule = module {

    single { Cicerone.create() }
    single { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().navigatorHolder }

    factory { SplashPresenter(get()) }
    factory { MainPresenter(get()) }
    factory { LoginViewPresenter(get()) }
    factory { EditProfilePresenter(get()) }
    factory { ProfileViewPresenter(get()) }
}