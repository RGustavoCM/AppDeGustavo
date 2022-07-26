/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.mx.utng.appdegustavo.ui.register

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mx.utng.appdegustavo.R
import com.mx.utng.appdegustavo.common.onClick
import com.mx.utng.appdegustavo.common.onTextChanged
import com.mx.utng.appdegustavo.registerPresenter
import com.mx.utng.appdegustavo.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterView {

  private val presenter by lazy { registerPresenter() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_register)
    presenter.setView(this)
    initUi()
  }

  private fun initUi() {
    usernameInput.onTextChanged { presenter.onUsernameChanged(it) }
    emailInput.onTextChanged { presenter.onEmailChanged(it) }
    passwordInput.onTextChanged { presenter.onPasswordChanged(it) }
    repeatPasswordInput.onTextChanged { presenter.onRepeatPasswordChanged(it) }

    registerButton.onClick { presenter.onRegisterTapped() }
  }

  override fun onRegisterSuccess() = startActivity(MainActivity.getLaunchIntent(this))

  override fun showSignUpError() {
  }

  override fun showUsernameError() {
    usernameInput.error = getString(R.string.username_error)
  }

  override fun showEmailError() {
    emailInput.error = getString(R.string.email_error)
  }

  override fun showPasswordError() {
    passwordInput.error = getString(R.string.password_error)
  }

  override fun showPasswordMatchingError() {
    repeatPasswordInput.error = getString(R.string.repeat_password_error)
  }
}