package com.pokemon.data.local.database

import com.pokemon.domain.model.Pokemon
import io.reactivex.Observable

interface Database {
    fun getAllPokemon(offset: Int, limit: Int): Observable<List<Pokemon>>
    fun savePokemon(data: List<Pokemon>): Observable<Void>
}