package com.pokemon.data.network

import com.pokemon.data.exception.PokemonException
import io.reactivex.ObservableEmitter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class DefaultCallback<T> internal constructor(private val emitter: ObservableEmitter<*>) :
    Callback<T> {
    override fun onResponse(
        call: Call<T>,
        response: Response<T>
    ) {
        if (isSuccessful(emitter, response)) {
            /*
            val body: ResponseEntity? = response.body() as ResponseEntity?
            if (body != null && body.getMessage() != null) {
                emitter.onError(PokemonException(body.getMessage()))
            }
             */
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        if (!emitter.isDisposed) {
            emitter.onError(PokemonException("Error in service" + t.message))
        }
    }

    private fun isSuccessful(
        emitter: ObservableEmitter<*>,
        response: Response<*>
    ): Boolean {
        return if (emitter.isDisposed) {
            false
        } else response.isSuccessful
    }

}