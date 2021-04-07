package com.pokemon.jv.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pokemon.domain.model.Pokemon
import com.pokemon.jv.databinding.FragmentListPokemonBinding
import com.pokemon.jv.internal.dagger.component.DaggerListPokemonFragmentComponent
import com.pokemon.jv.ui.ListPokemonViewModel
import com.pokemon.jv.ui.base.BaseFragment
import com.pokemon.jv.ui.presenter.ListPokemonPresenter
import com.pokemon.jv.ui.views.ListPokemonView
import javax.inject.Inject

class ListPokemonFragment :
    BaseFragment(),
    ListPokemonView {

    @Inject
    lateinit var presenter: ListPokemonPresenter
    private lateinit var listPokemonViewModel: ListPokemonViewModel
    private lateinit var binding: FragmentListPokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildInjection()
    }

    private fun buildInjection() {
        DaggerListPokemonFragmentComponent.builder()
            .applicationComponent(getAndroidApplication().getApplicationComponent())
            .build().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //listPokemonViewModel = ViewModelProviders.of(this).get(ListPokemonViewModel::class.java)
        binding = FragmentListPokemonBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
    }

    override fun successListPokemon(model: List<Pokemon>) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initUI() {
        presenter.setView(this)
        presenter.sendRequest(0, 20)
    }

    override fun context(): Context {
        return requireContext()
    }

    override fun showErrorMessage(message: String) {

    }

    override fun showErrorNetworkMessage(message: String) {

    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}