package com.pokemon.jv.ui.presenter

import com.pokemon.jv.ui.base.BasePresenter
import com.pokemon.jv.ui.views.ListPokemonView
import javax.inject.Inject

class ListPokemonPresenter @Inject constructor() : BasePresenter<ListPokemonView> {
    private lateinit var view: ListPokemonView

    override fun resume() {

    }

    override fun pause() {

    }

    override fun stop() {

    }

    override fun setView(view: ListPokemonView) {
        this.view = view
    }
}