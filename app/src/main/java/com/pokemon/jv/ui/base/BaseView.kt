package com.pokemon.jv.ui.base

import android.content.Context

interface BaseView {
    fun initUI()
    fun context(): Context
    fun showErrorMessage(message: String)
    fun showErrorNetworkMessage(message: String)
}