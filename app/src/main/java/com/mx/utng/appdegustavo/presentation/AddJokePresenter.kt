package com.mx.utng.appdegustavo.presentation

import com.mx.utng.appdegustavo.ui.addJoke.AddJokeView

interface AddJokePresenter : BasePresenter<AddJokeView> {

  fun addJokeTapped()

  fun onJokeTextChanged(jokeText: String)
}