package com.pokemon.domain.interactor

import com.pokemon.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class ListPokemon @Inject constructor(private val repository: UserRepository) : UseCase() {
    var offset: Int = 0
    var limit: Int = 0

    fun bindParams(offset: Int, limit: Int) {
        this.offset = offset
        this.limit = limit
    }

    override fun buildUseCaseObservable(): Observable<*> {
        return repository.getPokemonList(offset, limit)
    }
}