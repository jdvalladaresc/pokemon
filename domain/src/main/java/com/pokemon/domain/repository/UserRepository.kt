package com.pokemon.domain.repository

import com.pokemon.domain.model.Pokemon
import io.reactivex.Observable

interface UserRepository {
    fun getPokemonList(offset: Int, limit: Int): Observable<List<Pokemon>>
}