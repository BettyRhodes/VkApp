package com.example.vkapi.presentation.screen.edit

import android.text.TextUtils
import com.arellomobile.mvp.InjectViewState
import com.example.vkapi.R
import com.example.vkapi.presentation.common.BasePresenter
import com.example.vkapi.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class EditProfilePresenter @Inject constructor(private val router: Router): BasePresenter<EditProfileView>() {

    fun editProfile(firstName: String, lastName: String){
        when{
            TextUtils.isEmpty(firstName) -> viewState.showEditError(message = R.string.emptyName)
            TextUtils.isEmpty(lastName) -> viewState.showEditError(message = R.string.emptySurname)
            else -> router.backTo(Screen.ProfileViewScreen())
        }
    }
}