package com.pokemon.jv.ui.base

interface BasePresenter<T : BaseView> {
    fun resume()
    fun pause()
    fun stop()
    fun setView(view: T)
}