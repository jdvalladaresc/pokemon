package com.pokemon.domain.interactor.local

import com.pokemon.domain.executor.PostExecutionThread
import com.pokemon.domain.executor.ThreadExecutor
import com.pokemon.domain.interactor.UseCase
import com.pokemon.domain.model.Pokemon
import com.pokemon.domain.repository.UserLocalRepository
import io.reactivex.Observable
import javax.inject.Inject

class SaveListPokemonUseCase @Inject constructor(
    private val repository: UserLocalRepository,
    override val threadExecutor: ThreadExecutor,
    override val postExecutionThread: PostExecutionThread
) :
    UseCase(threadExecutor, postExecutionThread) {
    private lateinit var data: List<Pokemon>

    fun bindParams(data: List<Pokemon>) {
        this.data = data
    }

    override fun buildUseCaseObservable(): Observable<*> {
        return repository.saveLocalPokemonList(data)
    }
}