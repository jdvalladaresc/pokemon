package com.pokemon.domain.interactor

import com.pokemon.domain.executor.PostExecutionThread
import com.pokemon.domain.executor.ThreadExecutor
import com.pokemon.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetListPokemonUseCase @Inject constructor(
    private val repository: UserRepository,
    override val threadExecutor: ThreadExecutor,
    override val postExecutionThread: PostExecutionThread
) :
    UseCase(threadExecutor, postExecutionThread) {
    private var offset: Int = 0
    private var limit: Int = 0

    fun bindParams(offset: Int, limit: Int) {
        this.offset = offset
        this.limit = limit
    }

    override fun buildUseCaseObservable(): Observable<*> {
        return repository.getPokemonList(offset, limit)
    }
}