package com.example.vkapi.presentation.screen.profile

import com.arellomobile.mvp.MvpView
import com.example.vkapi.presentation.models.BaseItem
import com.example.vkapi.presentation.models.PostMessage
import com.example.vkapi.presentation.models.Profile

interface ProfileView: MvpView {
    fun showProfile(profile: Profile)
    fun showFeed(items: List<PostMessage>)
}