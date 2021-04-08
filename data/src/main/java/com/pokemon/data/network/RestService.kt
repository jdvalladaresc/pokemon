package com.pokemon.data.network

import com.pokemon.data.entity.NamedApiResourceList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestService {
    @GET(Endpoints.POKEMON)
    fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<NamedApiResourceList>
}