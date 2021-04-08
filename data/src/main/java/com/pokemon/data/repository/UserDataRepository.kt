package com.pokemon.data.repository

import com.pokemon.data.entity.mapper.PokemonItemMapper
import com.pokemon.data.entity.mapper.PokemonListMapper
import com.pokemon.data.network.RestApi
import com.pokemon.domain.model.EvolutionChainItem
import com.pokemon.domain.model.LocationAreaEncounterItem
import com.pokemon.domain.model.PokemonItem
import com.pokemon.domain.model.PokemonListItem
import com.pokemon.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataRepository @Inject constructor(private val restApi: RestApi) :
    UserRepository {

    override fun getPokemonList(offset: Int, limit: Int): Observable<List<PokemonListItem>> {
        return restApi.getPokemonList(offset, limit).map(PokemonListMapper::transform)
    }

    override fun getPokemon(id: Int): Observable<PokemonItem> {
        return restApi.getPokemon(id).map(PokemonItemMapper::transform)
    }

    override fun getPokemonEncounterList(id: Int): Observable<List<LocationAreaEncounterItem>> {
        return restApi.getPokemonEncounterList(id).map(PokemonItemMapper::transform)
    }

    override fun getEvolutionChain(id: Int): Observable<List<EvolutionChainItem>> {
        return restApi.getEvolutionChain(id).map(PokemonItemMapper::transform)
    }
}