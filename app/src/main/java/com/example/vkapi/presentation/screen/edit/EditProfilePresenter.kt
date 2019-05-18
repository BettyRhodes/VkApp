package com.example.vkapi.presentation.screen.edit

import android.text.TextUtils
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vkapi.App
import com.example.vkapi.R
import com.example.vkapi.presentation.entites.BasePresenter
import com.example.vkapi.presentation.navigation.Screen
import ru.terrakok.cicerone.Router

@InjectViewState
class EditProfilePresenter(private val router: Router): BasePresenter<EditProfileView>() {

    fun editProfile(firstName: String, lastName: String){
        when{
            TextUtils.isEmpty(firstName) -> viewState.showEditError(message = R.string.emptyName)
            TextUtils.isEmpty(lastName) -> viewState.showEditError(message = R.string.emptySurname)
            else -> router.backTo(Screen.ProfileViewScreen())
        }
    }
}