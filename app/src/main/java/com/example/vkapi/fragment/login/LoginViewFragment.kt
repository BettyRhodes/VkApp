package com.example.vkapi.fragment.login

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vkapi.R
import com.example.vkapi.common.afterTextChanged
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

        editText()
    }

    private fun editText(){
        email.afterTextChanged { textInputEmail.error = null }
        password.afterTextChanged { textInputPassword.error = null }
    }

    override fun showEmailError(message: Int) {
        textInputEmail.error = getString(message)
        textInputEmail.requestFocus()
    }

    override fun showPasswordError(message: Int) {
        textInputPassword.error = getString(message)
        textInputPassword.requestFocus()
    }

    override fun showLoginError(message: Int) {
        Snackbar.make(
            view ?: throw IllegalStateException(),
            getString(message),
            Snackbar.LENGTH_SHORT)
            .show()
    }
}