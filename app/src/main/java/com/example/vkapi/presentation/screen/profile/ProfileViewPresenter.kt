package com.example.vkapi.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.domain.repository.PostRepository
import com.example.vkapi.domain.repository.ProfileRepository
import com.example.vkapi.presentation.common.BasePresenter
import com.example.vkapi.presentation.models.PostMessage
import com.example.vkapi.presentation.models.Profile
import com.example.vkapi.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(
    private val router: Router,
    private val postRepository: PostRepository,
    private val profileRepository: ProfileRepository
) : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfile(profileRepository.getUser(1))

        viewState.showFeed(postRepository.getAll())
    }

    fun profileEdit() {
        router.navigateTo(Screen.EditScreen())
    }

    fun logout() {
        router.replaceScreen(Screen.LoginScreen())
    }
}