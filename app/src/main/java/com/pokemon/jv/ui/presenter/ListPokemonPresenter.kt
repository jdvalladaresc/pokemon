package com.pokemon.jv.ui.presenter

import com.pokemon.domain.interactor.DefaultObserver
import com.pokemon.domain.interactor.ListPokemonUseCase
import com.pokemon.domain.model.Pokemon
import com.pokemon.jv.ui.base.BasePresenter
import com.pokemon.jv.ui.views.ListPokemonView
import javax.inject.Inject

class ListPokemonPresenter @Inject constructor(val listPokemonUseCase: ListPokemonUseCase) :
    BasePresenter<ListPokemonView> {
    private lateinit var view: ListPokemonView

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {
        listPokemonUseCase.unSubscribe()
    }

    override fun setView(view: ListPokemonView) {
        this.view = view
    }

    fun sendRequest(offset: Int, limit: Int) {
        listPokemonUseCase.bindParams(offset, limit)
        listPokemonUseCase.execute(ListPokemonObservable())
    }

    inner class ListPokemonObservable : DefaultObserver<List<Pokemon>>() {
        override fun onStart() {
            super.onStart()
            view.showLoading()
        }

        override fun onNext(t: List<Pokemon>) {
            super.onNext(t)
            view.successListPokemon(t)
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            view.hideLoading()
            if (e is NullPointerException) {
                view.showErrorMessage("No pokemon data")
                return
            }
            view.showErrorMessage(e.message!!)
        }

        override fun onComplete() {
            super.onComplete()
            view.hideLoading()
        }
    }
}