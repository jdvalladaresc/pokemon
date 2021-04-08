package com.pokemon.domain.interactor

import com.pokemon.domain.executor.PostExecutionThread
import com.pokemon.domain.executor.ThreadExecutor
import com.pokemon.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetEvolutionChainUseCase @Inject constructor(
    private val repository: UserRepository,
    override val threadExecutor: ThreadExecutor,
    override val postExecutionThread: PostExecutionThread
) :
    UseCase(threadExecutor, postExecutionThread) {
    private var id: Int = 0

    fun bindParams(id: Int) {
        this.id = id
    }

    override fun buildUseCaseObservable(): Observable<*> {
        return repository.getEvolutionChain(id)
    }
}