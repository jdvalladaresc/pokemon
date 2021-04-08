package com.pokemon.domain.repository

import com.pokemon.domain.model.EvolutionChainItem
import com.pokemon.domain.model.LocationAreaEncounterItem
import com.pokemon.domain.model.PokemonItem
import com.pokemon.domain.model.PokemonListItem
import io.reactivex.Observable

interface UserRepository {
    fun getPokemonList(offset: Int, limit: Int): Observable<List<PokemonListItem>>
    fun getPokemon(id: Int): Observable<PokemonItem>
    fun getPokemonEncounterList(id: Int): Observable<List<LocationAreaEncounterItem>>
    fun getEvolutionChain(id: Int): Observable<List<EvolutionChainItem>>
}