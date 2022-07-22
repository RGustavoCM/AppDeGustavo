package com.mx.utng.appdegustavo.model

import com.mx.utng.appdegustavo.common.arePasswordsSame
import com.mx.utng.appdegustavo.common.isEmailValid
import com.mx.utng.appdegustavo.common.isUsernameValid

data class RegisterRequest(var name: String = "",
                           var email: String = "",
                           var password: String = "",
                           var repeatPassword: String = "") {

  fun isValid(): Boolean = isUsernameValid(name)
      && isEmailValid(email)
      && arePasswordsSame(password, repeatPassword)

}