package com.pokemon.domain.repository

import com.pokemon.domain.model.PokemonListItem
import io.reactivex.Observable

interface UserLocalRepository {
    fun getLocalPokemonList(offset: Int, limit: Int): Observable<List<PokemonListItem>>
    fun saveLocalPokemonList(data: List<PokemonListItem>): Observable<Void>
}