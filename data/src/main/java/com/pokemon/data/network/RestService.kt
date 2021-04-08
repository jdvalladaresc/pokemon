package com.pokemon.data.network

import com.pokemon.data.entity.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestService {
    @GET(Endpoints.POKEMON_LIST)
    fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<NamedApiResourceList>

    @GET(Endpoints.POKEMON_BY_ID)
    fun getPokemon(@Path("id") id: Int): Call<Pokemon>

    @GET(Endpoints.POKEMON_ENCOUNTER_BY_ID)
    fun getPokemonEncounterList(@Path("id") id: Int): Call<List<LocationAreaEncounter>>

    @GET(Endpoints.POKEMON_EVOLUTION_CHAIN)
    fun getEvolutionChain(@Path("id") id: Int): Call<EvolutionChain>
}