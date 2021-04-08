package com.pokemon.jv.ui.views

import com.pokemon.jv.ui.base.BaseView

interface LoginView : BaseView {
    fun goHome()
    fun getUsername(): String
    fun getPassword(): String
}