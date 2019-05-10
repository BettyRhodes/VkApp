package com.example.vkapi.fragment.login

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vkapi.R
import com.example.vkapi.fragment.BaseFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*
import java.lang.IllegalStateException

class LoginViewFragment: BaseFragment(R.layout.fragment_login), LoginView{

    @InjectPresenter
    lateinit var presenter: LoginViewPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginButton.setOnClickListener{
            presenter.login(email.text.toString(), password.text.toString())
        }
    }

    override fun showLoginError(message: Int) {
        Snackbar.make(
            view ?: throw IllegalStateException(),
            getString(message),
            Snackbar.LENGTH_SHORT)
            .show()
    }
}