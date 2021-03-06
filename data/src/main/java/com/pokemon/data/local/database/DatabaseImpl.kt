package com.pokemon.data.local.database

import com.pokemon.data.entity.mapper.PokemonTableDataMapper
import com.pokemon.data.exception.PokemonException
import com.pokemon.data.local.tables.PokemonTable
import com.pokemon.domain.model.PokemonListItem
import io.reactivex.Observable
import io.reactivex.ObservableEmitter

class DatabaseImpl(val database: LocalDatabase) : Database {
    override fun getAllPokemon(offset: Int, limit: Int): Observable<List<PokemonListItem>> {
        return Observable.create { emitter: ObservableEmitter<List<PokemonListItem>> ->
            val pokemons: List<PokemonTable> = database.getPokemonDao().getAllBetween(offset, limit)
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

    override fun savePokemon(data: List<PokemonListItem>): Observable<Void> {
        return Observable.create { emitter: ObservableEmitter<Void> ->
            database.getPokemonDao()
                .insert(PokemonTableDataMapper.transformList(data))
            if (!emitter.isDisposed) {
                emitter.onComplete()
            }
        }
    }
}