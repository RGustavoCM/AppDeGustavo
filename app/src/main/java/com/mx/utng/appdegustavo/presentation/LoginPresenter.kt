package com.mx.utng.appdegustavo.presentation

import com.mx.utng.appdegustavo.ui.login.LoginView

interface LoginPresenter : BasePresenter<LoginView> {

  fun onLoginTapped()

  fun onEmailChanged(email: String)

  fun onPasswordChanged(password: String)
}