package com.pokemon.jv.ui.views

import com.pokemon.domain.model.Pokemon
import com.pokemon.jv.ui.base.LoadingView

interface ListPokemonView : LoadingView {
    fun successListPokemon(model: List<Pokemon>)
}