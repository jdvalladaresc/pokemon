package com.pokemon.domain.repository

import com.pokemon.domain.model.Pokemon
import io.reactivex.Observable

interface UserLocalRepository {
    fun getLocalPokemonList(offset: Int, limit: Int): Observable<List<Pokemon>>
    fun saveLocalPokemonList(data: List<Pokemon>): Observable<Void>
}