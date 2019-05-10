package com.example.vkapi.fragment.edit

import com.arellomobile.mvp.MvpView

interface EditProfileView: MvpView {
    fun showEditError(message: Int)
}