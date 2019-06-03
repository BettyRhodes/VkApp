package com.example.vkapi.presentation.screen.edit

import android.text.TextUtils
import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.R
import com.example.vkapi.data.datasource.SessionDataSource
import com.example.vkapi.domain.entity.User
import com.example.vkapi.domain.repository.ProfileRepository
import com.example.vkapi.presentation.common.BasePresenter
import com.example.vkapi.presentation.converter.PresentationConverter
import com.example.vkapi.presentation.converter.ProfileConverter
import com.example.vkapi.presentation.models.Profile
import com.example.vkapi.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class EditProfilePresenter @Inject constructor(
    private val router: Router,
    private val sessionDataSource: SessionDataSource,
    private val profileRepository: ProfileRepository,
    private val profileConverter: ProfileConverter
) : BasePresenter<EditProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        profileRepository.getProfile()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showProfileInfo(profileConverter.convertTo(it))
                },
                {

                }).untilDestroy()
    }

    fun saveEdit(profile: Profile){
        profileRepository.saveEdit(profileConverter.convertFrom(profile))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    editProfile(profile)
                },
                {

                }
            ).untilDestroy()
    }

    private fun editProfile(profile: Profile) {
        when {
            TextUtils.isEmpty(profile.firstName) -> viewState.showEditError(message = R.string.emptyName)
            TextUtils.isEmpty(profile.lastName) -> viewState.showEditError(message = R.string.emptySurname)
            TextUtils.isEmpty(profile.home) -> viewState.showEditError(message = R.string.emptyCity)
            TextUtils.isEmpty(profile.birthday) -> viewState.showEditError(message = R.string.emptyCity)
            else -> router.backTo(Screen.ProfileViewScreen())
        }
    }
}