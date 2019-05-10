package com.example.vkapi.fragment.edit

import android.text.TextUtils
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vkapi.App
import com.example.vkapi.R
import com.example.vkapi.navigation.Screen

@InjectViewState
class EditProfilePresenter: MvpPresenter<EditProfileView>() {

    fun editProfile(firstName: String, lastName: String){
        when{
            TextUtils.isEmpty(firstName) -> viewState.showEditError(message = R.string.emptyName)
            TextUtils.isEmpty(lastName) -> viewState.showEditError(message = R.string.emptySurname)
            else -> App.INSTANCE.router.backTo(Screen.ProfileViewScreen())
        }
    }
}