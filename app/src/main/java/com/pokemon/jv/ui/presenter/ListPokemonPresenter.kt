package com.pokemon.jv.ui.presenter

import com.pokemon.data.utils.Utilities
import com.pokemon.domain.interactor.DefaultObserver
import com.pokemon.domain.interactor.GetListPokemonUseCase
import com.pokemon.domain.interactor.GetLocalListPokemonUseCase
import com.pokemon.domain.interactor.local.SaveListPokemonUseCase
import com.pokemon.domain.model.Pokemon
import com.pokemon.jv.model.mapper.PokemonModelMapper
import com.pokemon.jv.ui.base.BasePresenter
import com.pokemon.jv.ui.views.ListPokemonView
import javax.inject.Inject

class ListPokemonPresenter @Inject constructor(
    private val getListPokemonUseCase: GetListPokemonUseCase,
    private val getLocalListPokemonUseCase: GetLocalListPokemonUseCase,
    private val saveListPokemonUseCase: SaveListPokemonUseCase
) :
    BasePresenter<ListPokemonView> {
    private lateinit var view: ListPokemonView

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {
        getListPokemonUseCase.unSubscribe()
        getLocalListPokemonUseCase.unSubscribe()
        saveListPokemonUseCase.unSubscribe()
    }

    override fun setView(view: ListPokemonView) {
        this.view = view
    }

    fun getPokemonList(offset: Int, limit: Int) {
        Utilities.hasInternetConnection().subscribe { t1: Boolean, t2: Throwable? ->
            if (t1) {
                getListPokemonUseCase.bindParams(offset, limit)
                getListPokemonUseCase.execute(ListPokemonObservable())
            } else {
                getLocalListPokemonUseCase.bindParams(offset, limit)
                getLocalListPokemonUseCase.execute(LocalListPokemonObservable())
            }
        }
    }

    inner class LocalListPokemonObservable : DefaultObserver<List<Pokemon>>() {
        override fun onStart() {
            super.onStart()
            view.showLoading()
        }

        override fun onNext(t: List<Pokemon>) {
            super.onNext(t)
            view.successListPokemon(PokemonModelMapper.transform(t))
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

    inner class ListPokemonObservable : DefaultObserver<List<Pokemon>>() {
        override fun onStart() {
            super.onStart()
            view.showLoading()
        }

        override fun onNext(t: List<Pokemon>) {
            super.onNext(t)
            savePokemon(t)
            view.successListPokemon(PokemonModelMapper.transform(t))
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

    private fun savePokemon(data: List<Pokemon>) {
        saveListPokemonUseCase.bindParams(data)
        saveListPokemonUseCase.execute(SaveListPokemonObservable())
    }

    inner class SaveListPokemonObservable : DefaultObserver<Void>(){
        override fun onStart() {
            super.onStart()
        }

        override fun onComplete() {
            super.onComplete()
        }
    }
}