package com.example.vkapi.presentation.screen.edit

import com.arellomobile.mvp.MvpView
import com.example.vkapi.presentation.models.Profile

interface EditProfileView: MvpView {
    fun showEditError(message: Int)
    fun showProfileInfo(profile: Profile)
}