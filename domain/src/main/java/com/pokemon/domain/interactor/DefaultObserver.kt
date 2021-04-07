package com.pokemon.domain.interactor

import io.reactivex.Observer
import io.reactivex.observers.DisposableObserver

open class DefaultObserver<T> : DisposableObserver<T>(), Observer<T> {
    override fun onError(e: Throwable) {
        // no-op by default.
    }

    override fun onComplete() {
        // no-op by default.
    }

    override fun onNext(t: T) {
        // no-op by default.
    }
}
