package com.pokemon.data.local.database

import com.pokemon.data.entity.mapper.PokemonTableDataMapper
import com.pokemon.data.exception.PokemonException
import com.pokemon.data.local.tables.PokemonTable
import com.pokemon.domain.model.Pokemon
import io.reactivex.Observable
import io.reactivex.ObservableEmitter

class DatabaseImpl(val localDatabase: LocalDatabase) : Database {
    override fun getAllPokemon(): Observable<List<Pokemon>> {
        return Observable.create { emitter: ObservableEmitter<List<Pokemon>> ->
            val pokemons: List<PokemonTable> = localDatabase.getPokemonDao().getAll()
            if (!emitter.isDisposed) {
                if (pokemons == null || pokemons.isEmpty()) {
                    emitter.onError(PokemonException("No data"))
                } else {
                    emitter.onNext(PokemonTableDataMapper.transform(pokemons))
                    emitter.onComplete()
                }
            }
        }
    }
}