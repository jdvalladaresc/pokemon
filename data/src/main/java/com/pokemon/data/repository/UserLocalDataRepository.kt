package com.pokemon.data.repository

import com.pokemon.data.local.database.Database
import com.pokemon.domain.model.PokemonListItem
import com.pokemon.domain.repository.UserLocalRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalDataRepository @Inject constructor(private val database: Database) :
    UserLocalRepository {
    override fun getLocalPokemonList(offset: Int, limit: Int): Observable<List<PokemonListItem>> {
        return database.getAllPokemon(offset, limit)
    }

    override fun saveLocalPokemonList(data: List<PokemonListItem>): Observable<Void> {
        return database.savePokemon(data)
    }
}