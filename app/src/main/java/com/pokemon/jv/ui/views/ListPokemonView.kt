package com.pokemon.jv.ui.views

import com.pokemon.jv.model.PokemonModel
import com.pokemon.jv.ui.base.LoadingView

interface ListPokemonView : LoadingView {
    fun successListPokemon(list: List<PokemonModel>?)
}