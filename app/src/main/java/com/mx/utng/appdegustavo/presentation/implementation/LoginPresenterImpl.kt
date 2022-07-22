package com.mx.utng.appdegustavo.presentation.implementation

import com.mx.utng.appdegustavo.common.isEmailValid
import com.mx.utng.appdegustavo.common.isPasswordValid
import com.mx.utng.appdegustavo.firebase.authentication.FirebaseAuthenticationInterface
import com.mx.utng.appdegustavo.model.LoginRequest
import com.mx.utng.appdegustavo.presentation.LoginPresenter
import com.mx.utng.appdegustavo.ui.login.LoginView
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(
    private val authentication: FirebaseAuthenticationInterface
) : LoginPresenter {

  private lateinit var view: LoginView

  private val loginRequest = LoginRequest()

  override fun setView(view: LoginView) {
    this.view = view
  }

  override fun onLoginTapped() {
    if (loginRequest.isValid()) {
      authentication.login(loginRequest.email, loginRequest.password) { isSuccess ->
        if (isSuccess) {
          view.onLoginSuccess()
        } else {
          view.showLoginError()
        }
      }
    }
  }

  override fun onEmailChanged(email: String) {
    loginRequest.email = email

    if (!isEmailValid(email)) {
      view.showEmailError()
    }
  }

  override fun onPasswordChanged(password: String) {
    loginRequest.password = password

    if (!isPasswordValid(password)) {
      view.showPasswordError()
    }
  }
}

