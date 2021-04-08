package com.pokemon.data.repository

import com.pokemon.data.local.database.Database
import com.pokemon.domain.model.Pokemon
import com.pokemon.domain.repository.UserLocalRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalDataRepository @Inject constructor(private val database: Database) :
    UserLocalRepository {
    override fun getLocalPokemonList(offset: Int, limit: Int): Observable<List<Pokemon>> {
        return database.getAllPokemon(offset, limit)
    }

    override fun saveLocalPokemonList(data: List<Pokemon>): Observable<Void> {
        return database.savePokemon(data)
    }
}