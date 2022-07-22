package com.mx.utng.appdegustavo.ui.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mx.utng.appdegustavo.R
import com.mx.utng.appdegustavo.common.onClick
import com.mx.utng.appdegustavo.common.onTextChanged
import com.mx.utng.appdegustavo.common.showGeneralError
import com.mx.utng.appdegustavo.loginPresenter
import com.mx.utng.appdegustavo.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

  private val presenter by lazy { loginPresenter() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)
    presenter.setView(this)
    initUi()
  }

  private fun initUi() {
    emailInput.onTextChanged { presenter.onEmailChanged(it) }
    passwordInput.onTextChanged { presenter.onPasswordChanged(it) }
    loginButton.onClick { presenter.onLoginTapped() }
  }

  override fun showPasswordError() {
    passwordInput.error = getString(R.string.password_error)
  }

  override fun showEmailError() {
    emailInput.error = getString(R.string.email_error)
  }

  override fun onLoginSuccess() = startActivity(MainActivity.getLaunchIntent(this))

  override fun showLoginError() = showGeneralError(this)
}