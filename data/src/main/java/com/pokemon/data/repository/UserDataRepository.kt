package com.pokemon.data.repository

import com.pokemon.data.entity.mapper.PokemonMapper
import com.pokemon.data.network.RestApi
import com.pokemon.domain.model.Pokemon
import com.pokemon.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataRepository @Inject constructor(private val mRestApi: RestApi) :
    UserRepository {

    override fun getPokemonList(offset: Int, limit: Int): Observable<List<Pokemon>> {
        return mRestApi.getPokemonList(offset, limit).map(PokemonMapper::transform)
    }
}