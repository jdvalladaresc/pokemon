package com.pokemon.domain.interactor

import com.pokemon.domain.executor.PostExecutionThread
import com.pokemon.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

abstract class UseCase {
    private var disposable = Disposables.empty()

    private lateinit var threadExecutor: ThreadExecutor
    private lateinit var postExecutionThread: PostExecutionThread

    protected open fun UseCase(
        threadExecutor: ThreadExecutor?,
        postExecutionThread: PostExecutionThread?
    ) {
        this.threadExecutor = threadExecutor!!
        this.postExecutionThread = postExecutionThread!!
    }

    protected abstract fun buildUseCaseObservable(): Observable<*>

    fun execute(useCaseSubscriber: Observer<in Any?>?) {
        unSubscribe()
        disposable = buildUseCaseObservable()
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.getScheduler())
            .subscribeWith(useCaseSubscriber) as Disposable
    }

    fun unSubscribe() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}