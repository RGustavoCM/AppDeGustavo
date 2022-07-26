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

package com.mx.utng.appdegustavo.ui.addJoke

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mx.utng.appdegustavo.R
import com.mx.utng.appdegustavo.addJokePresenter
import com.mx.utng.appdegustavo.common.onClick
import com.mx.utng.appdegustavo.common.onTextChanged
import com.mx.utng.appdegustavo.common.showGeneralError
import kotlinx.android.synthetic.main.activity_add_joke.*

class AddJokeActivity : AppCompatActivity(), AddJokeView {

  private val presenter by lazy { addJokePresenter() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_joke)
    presenter.setView(this)

    initUi()
  }

  private fun initUi() {
    jokeDescription.onTextChanged { presenter.onJokeTextChanged(it) }
    addJoke.onClick { presenter.addJokeTapped() }
  }

  override fun showJokeError() {
    jokeDescription.error = getString(R.string.joke_error)
  }

  override fun removeJokeError() {
    jokeDescription.error = null
  }

  override fun onJokeAdded() = finish()

  override fun showAddJokeError() = showGeneralError(this)
}