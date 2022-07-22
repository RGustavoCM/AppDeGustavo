package com.mx.utng.appdegustavo.model

import com.mx.utng.appdegustavo.common.isEmailValid
import com.mx.utng.appdegustavo.common.isPasswordValid

data class LoginRequest(var email: String = "",
                        var password: String = "") {

  fun isValid() = isEmailValid(email) && isPasswordValid(password)
}