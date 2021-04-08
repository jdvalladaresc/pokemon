package com.pokemon.jv.ui.views

import com.pokemon.jv.model.DetailModel
import com.pokemon.jv.model.PokemonItemModel
import com.pokemon.jv.ui.base.LoadingView

interface PokemonDetailView : LoadingView {
    fun getPokemonId(): Int
    fun successPokemonDetail(model: PokemonItemModel)
    fun successPokemonEncounter(list: List<DetailModel>?)
    fun successEvolutionChain(list: List<DetailModel>?)
}