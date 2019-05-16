package com.example.vkapi.fragment.login

import com.arellomobile.mvp.MvpView

interface LoginView : MvpView {
    fun showLoginError(message: Int)
    fun showEmailError(message: Int)
    fun showPasswordError(message: Int)
}