package com.example.vkapi.presentation.screen.edit

import com.arellomobile.mvp.MvpView

interface EditProfileView: MvpView {
    fun showEditError(message: Int)
}