package com.pokemon.data.network

import android.content.Context
import com.pokemon.data.network.model.NamedApiResourceList
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
}