package com.mx.utng.appdegustavo.ui.login

interface LoginView {

  fun showPasswordError()

  fun showEmailError()

  fun onLoginSuccess()

  fun showLoginError()
}