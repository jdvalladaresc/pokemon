package com.pokemon.data.local.database

import com.pokemon.domain.model.Pokemon
import io.reactivex.Observable

interface Database {
    fun getAllPokemon(): Observable<List<Pokemon>>
}