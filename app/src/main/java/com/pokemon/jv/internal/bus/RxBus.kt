package com.pokemon.jv.internal.bus

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RxBus @Inject constructor() {
    private val mSubject: Subject<Any> =
        PublishSubject.create()

    fun send(o: Any) {
        mSubject.onNext(o)
    }

    fun toObservable(): Observable<Any> {
        return mSubject
    }
}