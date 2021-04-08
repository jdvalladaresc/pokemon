package com.pokemon.data.network

import com.pokemon.data.entity.EvolutionChain
import com.pokemon.data.entity.LocationAreaEncounter
import com.pokemon.data.entity.NamedApiResourceList
import com.pokemon.data.entity.Pokemon
import io.reactivex.Observable

interface RestApi {
    fun getPokemonList(
        offset: Int,
        limit: Int
    ): Observable<NamedApiResourceList?>

    fun getPokemon(id: Int): Observable<Pokemon?>
    fun getPokemonEncounterList(id: Int): Observable<List<LocationAreaEncounter>?>
    fun getEvolutionChain(id: Int): Observable<EvolutionChain?>
}