package com.pokemon.jv.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.pokemon.domain.model.Pokemon
import com.pokemon.jv.R
import com.pokemon.jv.internal.dagger.component.DaggerListPokemonFragmentComponent
import com.pokemon.jv.ui.ListPokemonViewModel
import com.pokemon.jv.ui.base.BaseFragment
import com.pokemon.jv.ui.presenter.ListPokemonPresenter
import com.pokemon.jv.ui.views.ListPokemonView
import javax.inject.Inject

class ListPokemonFragment @Inject constructor(private val presenter: ListPokemonPresenter) :
    BaseFragment(),
    ListPokemonView {

    private lateinit var listPokemonViewModel: ListPokemonViewModel

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
        listPokemonViewModel =
            ViewModelProviders.of(this).get(ListPokemonViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_list_pokemon, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_home)
        listPokemonViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
         */
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.sendRequest(0, 20)
    }

    override fun successListPokemon(model: Pokemon) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initUI() {
        presenter.setView(this)
    }

    override fun context(): Context {
        return requireContext()
    }

    override fun showErrorMessage(message: String) {

    }

    override fun showErrorNetworkMessage(message: String) {

    }
}