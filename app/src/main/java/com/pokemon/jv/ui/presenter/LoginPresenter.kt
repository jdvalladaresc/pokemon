package com.pokemon.jv.ui.presenter

import com.pokemon.data.sharedPreferences.PreferencesManager
import com.pokemon.jv.ui.base.BasePresenter
import com.pokemon.jv.ui.views.LoginView
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val preferences: PreferencesManager
) : BasePresenter<LoginView> {
    private lateinit var view: LoginView

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {

    }

    override fun setView(view: LoginView) {
        this.view = view
    }

    fun validate() {
        if (view.getUsername() == "pokemon" &&
            view.getPassword() == "pokemon"
        ) {
            preferences.save(view.getUsername())
            view.goHome()
        } else {
            view.showErrorMessage("Usuario y/o contrasenña incorrecto")
        }
    }

    fun validateScreen() {
        if (preferences.getUsername != null && preferences.getUsername!!.isNotEmpty()) {
            view.goHome()
        }
    }
}