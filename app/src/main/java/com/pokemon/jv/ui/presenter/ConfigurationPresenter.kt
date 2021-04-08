package com.pokemon.jv.ui.presenter

import com.pokemon.data.sharedPreferences.PreferencesManager
import com.pokemon.jv.ui.base.BasePresenter
import com.pokemon.jv.ui.views.ConfigurationView
import javax.inject.Inject

class ConfigurationPresenter @Inject constructor(
    private val preferencesManager: PreferencesManager
) : BasePresenter<ConfigurationView> {
    private lateinit var view: ConfigurationView

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {

    }

    override fun setView(view: ConfigurationView) {
        this.view = view
    }

    fun logout() {
        preferencesManager.clear()
        view.goLogin()
    }
}