package com.pokemon.jv.ui.presenter

import com.pokemon.domain.interactor.DefaultObserver
import com.pokemon.domain.interactor.GetEvolutionChainUseCase
import com.pokemon.domain.interactor.GetPokemonDetailUseCase
import com.pokemon.domain.interactor.GetPokemonEncounterUseCase
import com.pokemon.domain.model.EvolutionChainItem
import com.pokemon.domain.model.LocationAreaEncounterItem
import com.pokemon.domain.model.PokemonItem
import com.pokemon.jv.model.mapper.PokemonDetailModelMapper
import com.pokemon.jv.ui.base.BasePresenter
import com.pokemon.jv.ui.views.PokemonDetailView
import javax.inject.Inject

class PokemonDetailPresenter @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    private val getEvolutionChainUseCase: GetEvolutionChainUseCase,
    private val getPokemonEncounterUseCase: GetPokemonEncounterUseCase
) : BasePresenter<PokemonDetailView> {
    private lateinit var view: PokemonDetailView

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {
        getPokemonDetailUseCase.unSubscribe()
        getEvolutionChainUseCase.unSubscribe()
        getPokemonEncounterUseCase.unSubscribe()
    }

    override fun setView(view: PokemonDetailView) {
        this.view = view
    }

    fun getPokemonDetail() {
        getPokemonDetailUseCase.bindParams(view.getPokemonId())
        getPokemonDetailUseCase.execute(PokemonDetailObserver())

        getPokemonEncounterUseCase.bindParams(view.getPokemonId())
        getPokemonEncounterUseCase.execute(PokemonEncounterObserver())

        getEvolutionChainUseCase.bindParams(view.getPokemonId())
        getEvolutionChainUseCase.execute(EvolutionChainObserver())
    }

    inner class EvolutionChainObserver : DefaultObserver<List<EvolutionChainItem>>() {
        override fun onStart() {
            super.onStart()
            view.showLoading()
        }

        override fun onNext(t: List<EvolutionChainItem>) {
            super.onNext(t)
            view.successEvolutionChain(PokemonDetailModelMapper.transformEvolutionChain(t))
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

    inner class PokemonEncounterObserver : DefaultObserver<List<LocationAreaEncounterItem>>() {
        override fun onStart() {
            super.onStart()
            view.showLoading()
        }

        override fun onNext(t: List<LocationAreaEncounterItem>) {
            super.onNext(t)
            view.successPokemonEncounter(PokemonDetailModelMapper.transformLocation(t))
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

    inner class PokemonDetailObserver : DefaultObserver<PokemonItem>() {
        override fun onStart() {
            super.onStart()
            view.showLoading()
        }

        override fun onNext(t: PokemonItem) {
            super.onNext(t)
            view.successPokemonDetail(PokemonDetailModelMapper.transform(t))
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