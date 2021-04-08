package com.pokemon.data.network

import android.content.Context
import com.pokemon.data.entity.EvolutionChain
import com.pokemon.data.entity.LocationAreaEncounter
import com.pokemon.data.entity.NamedApiResourceList
import com.pokemon.data.entity.Pokemon
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import retrofit2.Call
import retrofit2.Response

class RestApiImpl(
    val context: Context,
    private val restService: RestService
) : RestApi {
    override fun getPokemonList(offset: Int, limit: Int): Observable<NamedApiResourceList?> {
        return Observable.create { emitter: ObservableEmitter<NamedApiResourceList?> ->
            restService.getPokemonList(offset, limit)
                .enqueue(object : DefaultCallback<NamedApiResourceList>(emitter) {
                    override fun onResponse(
                        call: Call<NamedApiResourceList>,
                        response: Response<NamedApiResourceList>
                    ) {
                        super.onResponse(call, response)
                        val body: NamedApiResourceList? = response.body()
                        emitter.onNext(body!!)
                        emitter.onComplete()
                    }
                })
        }
    }

    override fun getPokemon(id: Int): Observable<Pokemon?> {
        return Observable.create { emitter: ObservableEmitter<Pokemon?> ->
            restService.getPokemon(id)
                .enqueue(object : DefaultCallback<Pokemon>(emitter) {
                    override fun onResponse(
                        call: Call<Pokemon>,
                        response: Response<Pokemon>
                    ) {
                        super.onResponse(call, response)
                        val body: Pokemon? = response.body()
                        emitter.onNext(body!!)
                        emitter.onComplete()
                    }
                })
        }
    }

    override fun getPokemonEncounterList(id: Int): Observable<List<LocationAreaEncounter>?> {
        return Observable.create { emitter: ObservableEmitter<List<LocationAreaEncounter>?> ->
            restService.getPokemonEncounterList(id)
                .enqueue(object : DefaultCallback<List<LocationAreaEncounter>>(emitter) {
                    override fun onResponse(
                        call: Call<List<LocationAreaEncounter>>,
                        response: Response<List<LocationAreaEncounter>>
                    ) {
                        super.onResponse(call, response)
                        val body: List<LocationAreaEncounter>? = response.body()
                        emitter.onNext(body!!)
                        emitter.onComplete()
                    }
                })
        }
    }

    override fun getEvolutionChain(id: Int): Observable<EvolutionChain?> {
        return Observable.create { emitter: ObservableEmitter<EvolutionChain?> ->
            restService.getEvolutionChain(id)
                .enqueue(object : DefaultCallback<EvolutionChain>(emitter) {
                    override fun onResponse(
                        call: Call<EvolutionChain>,
                        response: Response<EvolutionChain>
                    ) {
                        super.onResponse(call, response)
                        val body: EvolutionChain? = response.body()
                        emitter.onNext(body!!)
                        emitter.onComplete()
                    }
                })
        }
    }
}