package com.example.vkapi.presentation.screen.profile

import com.arellomobile.mvp.MvpView
import com.example.vkapi.presentation.entites.PostMessage
import com.example.vkapi.presentation.entites.Profile

interface ProfileView: MvpView {
    fun showProfile(profile: Profile)
    fun showFeed(items: List<PostMessage>)
}