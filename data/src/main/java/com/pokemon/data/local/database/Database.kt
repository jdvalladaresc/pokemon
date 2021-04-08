package com.pokemon.data.local.database

import com.pokemon.domain.model.PokemonListItem
import io.reactivex.Observable

interface Database {
    fun getAllPokemon(offset: Int, limit: Int): Observable<List<PokemonListItem>>
    fun savePokemon(data: List<PokemonListItem>): Observable<Void>
}