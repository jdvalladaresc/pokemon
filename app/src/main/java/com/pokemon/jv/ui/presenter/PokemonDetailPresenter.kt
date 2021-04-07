package com.pokemon.jv.ui.presenter

import com.pokemon.jv.ui.base.BasePresenter
import com.pokemon.jv.ui.views.PokemonDetailView
import javax.inject.Inject

class PokemonDetailPresenter @Inject constructor() : BasePresenter<PokemonDetailView> {
    private lateinit var view: PokemonDetailView

    override fun resume() {

    }

    override fun pause() {

    }

    override fun stop() {

    }

    override fun setView(view: PokemonDetailView) {
        this.view = view
    }
}