package com.pokemon.jv.ui.base

interface BasePresenter<T : BaseView> {
    fun resume()
    fun pause()
    fun destroy()
    fun setView(view: T)
}