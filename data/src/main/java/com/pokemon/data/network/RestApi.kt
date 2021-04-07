package com.pokemon.data.network

import com.pokemon.data.network.model.NamedApiResourceList
import io.reactivex.Observable

interface RestApi {
    fun getPokemonList(
        offset: Int,
        limit: Int
    ): Observable<NamedApiResourceList?>
}